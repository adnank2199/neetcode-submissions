class Solution {
    Map<Integer,List<Integer>> adj;
    Set<Integer> visited;
    List<Integer> ans;
    Set<Integer> path;
    public List<Integer> topologicalSort(int n, int[][] edges) {
        adj = new HashMap<>();
        visited = new HashSet<>();
        path = new HashSet<>();

        for(int i = 0 ; i < n ; i++) {
            adj.put(i,new ArrayList<>());
        }

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            if(!dfs(i))
            return new ArrayList<>();
        }
        
        Collections.reverse(ans);
        return ans;
    }

    public boolean dfs(int node) {
        if(path.contains(node)) 
        return false ;
        if(visited.contains(node))
        return true;

        visited.add(node);
        path.add(node);

        for(int i : adj.get(node)) 
        if(!dfs(i))
        return false;

        ans.add(node);
        path.remove(node);

        return true;

    }
}
