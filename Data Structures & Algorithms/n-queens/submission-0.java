class Solution {

    private Set<Integer> col = new HashSet<>();
    private Set<Integer> pos = new HashSet<>();
    private Set<Integer> neg = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] c : board) {
            Arrays.fill(c,'.');
        }
        List<List<String>> ans = new ArrayList<>();
        helper(0, ans , n , board);
        return ans;
    }

    public void helper(int i ,List<List<String>> ans , int n , char[][] board) {
        if(i==n) {
            List<String> row = new ArrayList<>();
            for(char [] c : board) {
                row.add(new String(c));
            }
            ans.add(row);
            return;
        }

        for(int j=0;j<n;j++) {
            if(col.contains(j) || neg.contains(i+j) || pos.contains(i-j))
            continue;
            board[i][j]='Q';
            col.add(j);
            neg.add(i+j);
            pos.add(i-j);
            helper(i+1,ans,n,board);
            col.remove(j);
            neg.remove(i+j);
            pos.remove(i-j);
            board[i][j]='.';
        }


    }
}
