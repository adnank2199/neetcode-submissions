class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character,Boolean> row ;
        HashMap<Character,Boolean> col;
        HashMap<Character,Boolean> sq;
        for(int i=0 ; i<9;i++) {
            row = new HashMap<>();
            for(int j=0 ; j<9;j++) {
                if (board[i][j] == '.') continue;
                if(row.containsKey(board[i][j]))
                return false;
                row.put(board[i][j],true);
            }
        }
        for(int i=0 ;i<9;i++) {
            col= new HashMap<>();
            for(int j=0; j<9;j++) {
                if (board[j][i] == '.') continue;
                if(col.containsKey(board[j][i]))
                return false;
                col.put(board[j][i],true);
            }
        }
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                sq = new HashMap<>();
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        if (board[i][j] == '.') continue;
                        if (sq.containsKey(board[i][j]))
                            return false;
                        sq.put(board[i][j], true);
                    }
                }
            }

        }
        return true;
    }
}
