class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int index = nums.length-1;
        Arrays.fill(dp,9999);
        dp[index] = 0;
        for(int i = nums.length-2 ; i>=0 ;i--) {
            for(int j=1; j<=nums[i];j++) {
                if(i+j <nums.length)
                dp[i] = Math.min(dp[i],1+dp[i+j]);
            }
        }
        return dp[0];
    }

}
