class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int i =0;i<numCourses ;i++) {
            adj.put(i,new ArrayList<>());
        }
        for(int i[] : prerequisites) {
            adj.get(i[0]).add(i[1]);
        }
        for(int i =0 ; i<numCourses ; i++) 
        if(!dfs(adj,i))
        return false;
        return true;
    }

    public boolean dfs(Map<Integer,List<Integer>> adj , int i) {
        if(visited.contains(i))
        return false;
        if(adj.get(i).isEmpty()) 
        return true;

        visited.add(i);
        for(int j : adj.get(i)) {
            if(!dfs(adj,j))
            return false;
        }
        visited.remove(i);
        adj.put(i,new ArrayList<>());
        return true;
    }
}
