class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1!=edges.length) 
        return false; 

        Map<Integer,List<Integer>> adj = new HashMap<>() ;
        Set<Integer> visited = new HashSet<>();

        for(int i=0;i<n;i++) 
        adj.put(i , new ArrayList<>());

        for(int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited.add(0);

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int i : adj.get(curr)) {
                if(!visited.contains(i)) {
                    q.offer(i);
                    visited.add(i);
                }
            }
        }

        return visited.size() == n;
    }
}