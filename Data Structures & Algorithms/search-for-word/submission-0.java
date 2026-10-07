class Solution {
    int ROWS ; 
    int COLS ;
    int len ;
    Set<String> visited = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        ROWS = board.length ;
        COLS = board[0].length ;
        len = word.length();
        for(int i =0;i<ROWS ;i++)
        for(int j =0;j<COLS ;j++) 
        if(helper(board , word , i, j , 0))
        return true;
        return false;
    }

    public boolean helper (char[][] board, String word , int i , int j , int itr) {
        if(i==ROWS || j==COLS || Math.min(i,j) < 0 || visited.contains(Arrays.toString(new int[] {i,j})) || board[i][j] != word.charAt(itr))
        return false;
        if(itr+1 == len)
        return true;
        visited.add(Arrays.toString(new int[] {i,j}));
        boolean result = helper(board,word,i+1,j ,itr+1) || helper(board,word,i-1,j,itr+1) || helper(board,word,i,j+1,itr+1) || helper(board,word ,i,j-1,itr+1); 
        visited.remove(Arrays.toString(new int[] {i,j}));
        return result;

    }
}
