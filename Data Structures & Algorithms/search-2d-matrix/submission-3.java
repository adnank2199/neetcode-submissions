class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0 ; 
        int r = row * col -1 ;

        while(l<=r) {
            int mid = (l+r)/2 ; 
            int rowTemp = mid / col;
            int colTemp = mid % col;
            if(matrix[rowTemp][colTemp] > target) {
                r = mid -1;
            }
            else if(matrix[rowTemp][colTemp] < target) {
                l = mid +1;
            }
            else 
            return true;
        }
        return false;
    }
}
