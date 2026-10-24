class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int cmax = 0 , cmin = 0 ; 
        int max = nums[0] , min = nums[0];
        int total  = 0 ;
        for(int num : nums) {
            cmax = Math.max(cmax+num, num);
            cmin = Math.min(cmin+num , num);
            total+=num;
            max = Math.max(cmax , max);
            min = Math.min(cmin,min);
        }

        return max > 0 ? Math.max(max,total-min) : max;
    }
}