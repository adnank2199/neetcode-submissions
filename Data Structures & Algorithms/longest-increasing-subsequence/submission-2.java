class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 1 ;
        int maxLen = 1;
        for(int i = nums.length-2 ; i>=0 ; i--) {
            int len = 1 ;
            for(int j = i+1 ; j < nums.length ;j++) {
                if(nums[i] < nums[j])
                len = Math.max(len , 1+ dp[j]);
            }
            dp[i]=len;
            maxLen = Math.max(maxLen , dp[i]);
        }
        return maxLen;
    }
}
