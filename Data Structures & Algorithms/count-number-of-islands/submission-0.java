class Solution {
    Set<String> s ;
    public int numIslands(char[][] grid) {
        s = new HashSet<>();
        int count = 0 ;
        for(int i =0 ;i<grid.length;i++) {
            for(int j =0;j<grid[0].length;j++) {
                if(grid[i][j] == '1' && !s.contains(Arrays.toString(new int[] {i,j})))
                {count++; dfs(grid,i,j);};
            }
        }
        return count;
    }

    public void dfs(char[][] grid , int i , int j) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if(Math.min(i,j) < 0 || i == ROWS || j == COLS || s.contains(Arrays.toString(new int[]{i,j})) || grid[i][j]=='0') 
        return ;

        if(grid[i][j]=='1') 
        s.add(Arrays.toString(new int[] {i,j}));

        dfs(grid , i+1 , j);
        dfs(grid , i-1 , j);
        dfs(grid , i , j+1);
        dfs(grid, i , j-1);

        return;
    }
}
