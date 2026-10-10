class Solution {
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int count = 0 ;
        for(int i = 0 ;i<n ;i++) {
            adj.put(i,new ArrayList<>());
        }
        for(int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        for(int i =0;i<n;i++ ) {
            if(!visited.contains(i)) {
                dfs(adj,i);
                count++;
            }
        }
        return count;
    }

    public void dfs(Map<Integer,List<Integer>> adj , int j) {
        Queue<Integer> q = new ArrayDeque<>() ;
        q.offer(j);
        visited.add(j) ;

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int i : adj.get(curr)) {
                if(!visited.contains(i)) {
                    q.offer(i);
                    visited.add(i);
                }
            }
        }
    }
}
