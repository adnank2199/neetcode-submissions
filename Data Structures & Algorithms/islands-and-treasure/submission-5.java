class Solution {
    Set<String> visited = new HashSet<>();
    public void islandsAndTreasure(int[][] grid) {
        int a ;
        int b ;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0 ;i<grid.length;i++) 
        for(int j =0 ; j<grid[0].length;j++) {
            if(grid[i][j] == 0) 
            {q.offer(new int[] {i,j});
            visited.add(Arrays.toString(new int[] {i,j}));}
        }
        bfs(grid,q);
    }

    public void bfs(int[][] grid ,Queue<int[]> q) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int len = 1;
        while(!q.isEmpty()) {
            int size = q.size() ;
            for(int ie =0;ie<size;ie++) {
                int[] curr = q.poll();

                int[][] neighbors = {{1,0} , {0,1} , {-1,0} , {0,-1}};
                for(int[] i : neighbors) {
                    if(
                        Math.min(curr[0]+i[0] , curr[1]+i[1]) <0 ||
                        curr[0]+i[0] == ROWS ||
                        curr[1]+i[1] == COLS || 
                        visited.contains(Arrays.toString(new int[] {curr[0]+i[0] , curr[1]+i[1]})) ||
                        grid[curr[0]+i[0]][curr[1]+i[1]] == -1 ||
                        grid[curr[0]+i[0]][curr[1]+i[1]] == 0

                    )
                    continue;

                    q.offer(new int[] {curr[0]+i[0] , curr[1] + i[1]});
                    visited.add(Arrays.toString(new int[] {curr[0]+i[0] , curr[1]+i[1]}));
                    grid[curr[0]+i[0]][curr[1]+i[1]] = Math.min(grid[curr[0]+i[0]][curr[1]+i[1]] , len);
                }
            }
            len++;
        }
        return;
    }
}
