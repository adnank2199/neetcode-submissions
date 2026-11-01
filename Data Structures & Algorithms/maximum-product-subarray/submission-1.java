class Solution {
    public int maxProduct(int[] nums) {
        int currmax = 1;
        int currmin = 1;
        int res = nums[0] ;

        for(int i : nums) {
            int tmp = currmax * i ;
            currmax = Math.max(Math.max(currmax*i , currmin*i) , i);
            currmin = Math.min(Math.min(tmp,currmin*i),i);
            res = Math.max(res,currmax);
        }

        return res;
    }
}
