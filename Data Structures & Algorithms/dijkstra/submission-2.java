class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer,ArrayList<int[]>> adj = new HashMap<>() ;
        for(int i=0;i<n;i++ ) {
            adj.put(i,new ArrayList<>()) ;
        }

        for(List<Integer> i : edges) {
            int s = i.get(0);
            int d = i.get(1);
            int w = i.get(2);

            adj.get(s).add(new int[] {d,w});
        }

        Map<Integer,Integer> ans = new HashMap<>();
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        minheap.offer(new int[] {0,src});

        while(!minheap.isEmpty()) {
            int[] curr = minheap.poll();
            int source = curr[1];
            int weight = curr[0];

            if(ans.containsKey(source)) 
            continue;

            ans.put(source,weight);

            for(int[] i : adj.get(source)) {
                int nsource = i[0];
                int nweight = i[1];
                if(ans.containsKey(nsource)) 
                continue;
                minheap.offer(new int[] {nweight+weight,nsource});
            }
        }


        for(int i = 0;i<n ;i++){
            if(!ans.containsKey(i))
            ans.put(i,-1);
        }

        return ans;
    }  
}
