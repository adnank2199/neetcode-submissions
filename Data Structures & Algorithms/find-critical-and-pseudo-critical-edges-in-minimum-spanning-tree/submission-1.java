class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int mst = prims(n,edges , -1 , -1) ;
        List<List<Integer>> ans = new ArrayList<>();
        int count = 0 ;
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for(int[] i : edges) {
           //include 
            int include = prims(n,edges,-1,count);
            int exclude = prims(n,edges,count,-1);

            if((exclude == -1 || exclude > mst) && include == mst) 
            ans.get(0).add(count);

            else if(exclude == mst && include == mst) 
            ans.get(1).add(count);
            
            count++;
        }
        return ans;
    }

    public int prims(int n , int[][] edges , int exclude ,int include) {
        Map<Integer,List<int[]>> adj = new HashMap<>();

        for(int i =0 ;i<n;i++) {
            adj.put(i,new ArrayList<>());
        }
        int count = 0; 
        for(int[] i : edges) {
            if(count!=exclude)
            {adj.get(i[0]).add(new int[] {i[1] , i[2]});
            adj.get(i[1]).add(new int[] {i[0] , i[2]});}
            count++;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        Set<Integer> visited = new HashSet<>();
        int tc = 0 ;
        if(include==-1)
        heap.offer(new int[] {0,0,0});
        else {
            visited.add(edges[include][0]);
            visited.add(edges[include][1]);
            for(int[] i : adj.get(edges[include][0])) {
                if(visited.contains(i[0])) 
                continue;
                heap.offer(new int[] {edges[include][0], i[0] , i[1]});
            }
            for(int[] i : adj.get(edges[include][1])) {
                if(visited.contains(i[0])) 
                continue;
                heap.offer(new int[] {edges[include][1] , i[0] , i[1]});
            }
            tc += edges[include][2];
        } 
        

        while(!heap.isEmpty()) {
            int[] curr = heap.poll();
            if(visited.contains(curr[1]))
            continue;
            visited.add(curr[1]);
            tc+=curr[2];

            for(int[] i : adj.get(curr[1])) {
                if(visited.contains(i[0])) 
                continue;
                heap.offer(new int[] {curr[1] , i[0] , i[1]});
            }

        }

        return visited.size()!=n ? -1 : tc;
    }
}