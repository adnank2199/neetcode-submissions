class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;
        for(int i =0 ;i<grid.length;i++) 
        for(int j=0 ;j < grid[0].length ;j++) {
        if(grid[i][j]==2)
        q.offer(new int[] {i,j});
        else if(grid[i][j] == 1) {
            count++;
        }
        }
        Set<String> visited = new HashSet<>();
        int len =0  ;
        while(q.size()!=0) {
            int size = q.size();
            for(int j =0;j<size;j++) {
                int[] curr = q.poll();
                
                int[][] nei = {{1,0} , {-1,0} , {0,1} , {0,-1}};

                for(int[] i : nei) {
                    if(
                        Math.min(curr[0]+i[0] , curr[1]+i[1]) < 0 || curr[0]+i[0]==ROWS || curr[1]+i[1]==COLS || visited.contains(Arrays.toString(new int[] {curr[0]+i[0] , curr[1]+i[1]})) 
                        || grid[curr[0]+i[0]][curr[1]+i[1]] != 1
                    )
                    continue;
                    q.offer(new int[] {curr[0]+i[0] , curr[1]+i[1]});
                    visited.add(Arrays.toString(new int[] {curr[0]+i[0] , curr[1]+i[1]}));
                    count--;
                }
            }
            if(q.size()!=0)
            len++; 
        }
        if(count != 0)
        return -1 ;
        return len;
    }
}
