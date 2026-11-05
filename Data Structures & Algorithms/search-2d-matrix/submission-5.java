class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int L = 0;
        int R = ROWS * COLS - 1;

        while(L<=R) {
            int mid = (L+R)/2;
            int row = mid / COLS ;
            int col = mid % COLS ;

            if(matrix[row][col] > target) {
                R = mid - 1;
            }
            else if(matrix[row][col] < target) {
                L = mid +1 ;
            }
            else 
            return true;
        }

        return false;
    }
}
