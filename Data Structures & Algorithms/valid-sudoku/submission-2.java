class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> helper;

        for(int i =0 ; i < board.length ; i++) {
            helper = new HashSet<>();
            for(int j =0 ; j < board[0].length ; j++) {
                if(board[i][j]=='.')
                continue;
                if(helper.contains(board[i][j]))
                return false;
                helper.add(board[i][j]);
            }
        }

        for(int i=0; i<board[0].length ;i++) {
            helper = new HashSet<>();
            for(int j = 0 ;j < board.length ;j++) {
                if(board[j][i]=='.')
                continue;
                if(helper.contains(board[j][i]))
                return false;
                helper.add(board[j][i]);
            }
        }
        for(int row = 0 ; row < board.length ; row+=3) {
            for(int col = 0 ; col < board[0].length ; col+=3) {
                helper = new HashSet<>() ;
                for(int i = row ; i < row+3; i++) {
                    for(int j = col ; j < col+3 ; j++) {
                        if(board[i][j] == '.')
                        continue;
                        if(helper.contains(board[i][j]))
                        return false;
                        helper.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
} 
