class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adj = new HashMap<>();

        for(int i=1 ; i<=n ; i++) {
            adj.put(i,new ArrayList<>());
        }

        for(int[] i : times) {
            int source = i[0];
            int dest = i[1];
            int weight = i[2];

            adj.get(source).add(new int[] {dest,weight});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        int[] ans = new int[n+1];
        

        Arrays.fill(ans,-1);
        ans[0]=0;

        heap.offer(new int[] {k,0});

        while(!heap.isEmpty()) {
            int[] curr = heap.poll();

            int destination = curr[0];
            int weight = curr[1];

            if(ans[destination]!=-1)
            continue;

            ans[destination] = weight;

            for(int[] i : adj.get(destination)) {
                int dest = i[0];
                int wei = i[1];

                if(ans[dest]!=-1)
                continue;

                heap.offer(new int[] {dest,wei+weight});
            }

            

            
        }
        int max = Integer.MIN_VALUE;

            for(int i : ans) {
                if(i==-1)
                return -1;
                max = Math.max(i,max);
            }

            return max;
    }
}
