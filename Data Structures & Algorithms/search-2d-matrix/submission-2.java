class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0 ;
        int l = matrix[0].length-1;
        int row = -1;
        for(int i =0 ; i<matrix.length ;i++ ) {
            if(target > matrix[i][r] && target < matrix [i][l]) {
                row=i;
                break;
            }
            if(target == matrix[i][r] || target == matrix[i][l])
            return true;
        }
        if(row==-1)
        return false;

        while(r<=l) {
            int mid = (r+l)/2;
            if(matrix[row][mid] < target) 
            r = mid+1;
            else if(matrix[row][mid] > target)
            l = mid-1;
            else
            return true;
        }
        return false ;
    }
}
