class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS = grid.length ; 
        int COLS = grid[0].length;
        
        if (grid[0][0] == 1 || grid[ROWS - 1][COLS - 1] == 1) {
            return -1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.offer(new int[] {0,0});
        visited.add(Arrays.toString(new int[] {0,0}));

        if(grid.length == 1 && grid[0].length==1 && grid[0][0] == 0)
        return 1;

        int len = 1;

        while(q.size()!=0) {
            int size = q.size();
            for(int j =0 ;j<size;j++) {
                int[] curr = q.poll();
                if(curr[0] == ROWS-1 && curr[1] == COLS-1) {
                    return len;
                }

                int[][] nei = {{1,0} , {-1,0} , {0,1} , {0,-1} , {1,1} , {-1,-1} ,{1,-1} , {-1,1}};

                for(int[] i : nei) {
                    if(
                        Math.min(curr[0]+i[0] , curr[1]+i[1]) < 0 ||
                        curr[0]+i[0]==ROWS ||
                        curr[1]+i[1]==COLS || 
                        visited.contains(Arrays.toString(new int[] {curr[0]+i[0] , curr[1]+i[1]})) ||
                        grid[curr[0]+i[0]][curr[1]+i[1]] == 1
                    )
                    continue;

                    q.offer(new int[] {curr[0]+i[0] , curr[1]+i[1]});
                    visited.add(Arrays.toString(new int[] {curr[0]+i[0] , curr[1]+i[1]}));
                }
                
            }
            len++;
        }
        return -1;
    }
}