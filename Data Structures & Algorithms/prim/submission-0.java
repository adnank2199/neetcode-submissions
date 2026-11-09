class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer,List<int[]>> adj = new HashMap<>();

        for(int i = 0; i<n ;i++) {
            adj.put(i , new ArrayList<>());
        }

        for(List<Integer> i : edges) {
            adj.get(i.get(0)).add(new int[] {i.get(2) , i.get(1)});
            adj.get(i.get(1)).add(new int[] {i.get(2) , i.get(0)});
        }

        int totalCost = 0 ;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int[] i : adj.get(0)) {
            heap.offer( new int[] {i[0] , 0 , i[1]});
        }

        while(!heap.isEmpty()) {
            int curr[] =heap.poll();
            if(visited.contains(curr[2]))
            continue;
            visited.add(curr[2]);

            totalCost+=curr[0];

            for(int[] i : adj.get(curr[2])) {
                if(visited.contains(i[1]))
                continue;
                heap.offer(new int[] {i[0],curr[2],i[1]});
            }
        }

        return visited.size() == n ? totalCost : -1;
        
    }
}    
