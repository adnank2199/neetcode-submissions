class Solution {
    public int swimInWater(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        heap.offer(new int[] {grid[0][0],0,0});

        int[][] visited = new int[ROWS][COLS];

        for(int i =0;i<ROWS;i++) {
            Arrays.fill(visited[i],-1);
        }

        int[][] directions = new int[][] {{1,0} , {0,1} , {-1,0} , {0,-1}};

        while(!heap.isEmpty()) {
            int[] curr = heap.poll();

            if(curr[1] == ROWS-1 && curr[2] == COLS-1) 
            return Math.max(curr[0],grid[curr[1]][curr[2]]);

            if(visited[curr[1]][curr[2]]!=-1) 
            continue;

            visited[curr[1]][curr[2]] = 1;

            for(int[] i : directions) {
                if(
                    Math.min(curr[1]+i[0],curr[2]+i[1]) < 0 || 
                    curr[1]+i[0] == ROWS || 
                    curr[2]+i[1] == COLS || 
                    visited[curr[1]+i[0]][curr[2]+i[1]] != -1
                )
                continue;
                heap.offer(new int[] {Math.max(curr[0],grid[curr[1]+i[0]][curr[2]+i[1]]),curr[1]+i[0],curr[2]+i[1]});
            }
        }
        return -1;

    }
}
