class Solution {
    int ROWS;
    int COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS=heights.length;
        COLS=heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        for(int i =0;i<ROWS ;i++) {
            q.offer(new int[] {i,0});
        }
        for(int i = 0;i<COLS;i++) {
            q.offer(new int[] {0,i});
        }
        Set<List<Integer>> pacific = bfs(heights , q);

        // q = new ArrayDeque<>();
        for(int i =0;i<ROWS ;i++) {
            q.offer(new int[] {i,COLS-1});
        }
        for(int i = 0;i<COLS;i++) {
            q.offer(new int[] {ROWS-1,i});
        }
        Set<List<Integer>> atlantic = bfs(heights , q);

        for(List<Integer> i : pacific) {
            if(atlantic.contains(i)) 
            ans.add(i);
        }

        return ans;
    }

    public Set<List<Integer>> bfs(int[][] heights ,Queue<int[]> q  ) {
        Set<List<Integer>> result = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(int[] i : q) 
        visited.add(Arrays.toString(i));

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0 ;i<size ;i++) {
                int[] curr = q.poll();
                result.add(new ArrayList<>(List.of(curr[0],curr[1])));
                int[][] neighbors = {{1,0} , {0,1} , {-1,0} , {0,-1}};
                for(int[] j : neighbors) {
                    if(
                        Math.min(curr[0] + j[0] , curr[1] + j[1]) < 0 ||
                        curr[0] + j[0] == ROWS || 
                        curr[1] + j[1] == COLS || 
                        visited.contains(Arrays.toString(new int[] {curr[0]+j[0] , curr[1]+j[1]})) || 
                        heights[curr[0]+j[0]][curr[1]+j[1]] < heights[curr[0]][curr[1]]
                    )
                    continue;
                    q.offer(new int[] {curr[0]+j[0] , curr[1]+j[1]});
                    visited.add(Arrays.toString(new int[] {curr[0]+j[0] , curr[1]+j[1]}));
                }
            }
        }
        return result;
    }
}
