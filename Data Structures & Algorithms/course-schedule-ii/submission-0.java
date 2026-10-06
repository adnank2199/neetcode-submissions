class Solution {
    Set<Integer> visited = new HashSet<>();
    Set<Integer> completed = new HashSet<>();
    List<Integer> order = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int[] ans = new int[numCourses];
        for(int i =0;i<numCourses ;i++) {
            adj.put(i,new ArrayList<>());
        }
        for(int i[] : prerequisites) {
            adj.get(i[0]).add(i[1]);
        }
        for(int i =0 ; i<numCourses ; i++) 
        if(!dfs(adj,i))
        return new int[0];
        int itr = 0;
        for(int i : order) {
            ans[itr] = i;
            itr++;
        }
        return ans; 
    }

    public boolean dfs(Map<Integer,List<Integer>> adj , int i) {
        if(visited.contains(i))
        return false;
        if(completed.contains(i))
        return true;

        visited.add(i);
        for(int j : adj.get(i)) {
            if(!dfs(adj,j))
            return false;
        }
        visited.remove(i);
        completed.add(i);
        order.add(i);
        return true;
    }
}