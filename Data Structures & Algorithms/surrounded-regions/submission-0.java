class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new ArrayDeque<>();
        for(int i =0;i<board.length;i++) 
        for(int j =0;j<board[0].length;j++) {
            if(board[i][j]=='O' && (i==0 || i==board.length-1 || j==0 || j==board[0].length-1))
            q.add(new int[] {i,j});
        }
        bfs(board,q);
        for(int i = 0; i<board.length ; i++) 
        for(int j = 0 ; j<board[0].length ; j++) {
            if(board[i][j]=='O')
            board[i][j]='X';
            else if(board[i][j] == 'S')
            board[i][j] = 'O';
        }
    }

    public void bfs(char[][] board,Queue<int[]> q) {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            board[curr[0]][curr[1]] = 'S' ;

            int[][] nei = {{1,0} , {0,1} , {-1,0} , {0,-1}};
            for(int[] i : nei) {
                if(
                    Math.min(curr[0]+i[0] , curr[1]+i[1]) < 0 ||
                    curr[0]+i[0] == board.length ||
                    curr[1]+i[1] == board[0].length || 
                    board[curr[0]+i[0]][curr[1]+i[1]] != 'O'
                )
                continue;
                q.offer(new int[] {curr[0]+i[0] , curr[1]+i[1]});
            }
        }
    }
}
