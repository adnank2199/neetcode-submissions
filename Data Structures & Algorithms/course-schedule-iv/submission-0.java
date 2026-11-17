class Solution {
    boolean[][] cache ;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] pre, int[][] queries) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        cache = new boolean[numCourses][numCourses];
        for(int i=0 ; i<numCourses ; i++) {
            adj.put(i , new ArrayList<>());
        }
        for(int[] i : pre) {
            adj.get(i[0]).add(i[1]);
        }
        
        for(int i=0;i<numCourses;i++) {
            dfs(adj,i,i);
        }

        List<Boolean> ans = new ArrayList<>();

        for(int[] i : queries) {
            if(cache[i[0]][i[1]])
            ans.add(true);
            else
            ans.add(false);
        }

        return ans;

        

    }
    

    public void dfs(Map<Integer,List<Integer>> adj , int curr , int start) {
        if(cache[start][curr] == true)
        return;

        cache[start][curr] = true;

        for(int i : adj.get(curr)) {
            dfs(adj,i,start);
        }

        return ;

    }
}