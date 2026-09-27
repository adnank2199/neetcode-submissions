class Solution {
    private int[] cache;
    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];
        cache = new int[nums.length];
        Arrays.fill(cache,-1);
        int ans1 = helper(Arrays.copyOfRange(nums,0,nums.length-1),0) ;
        Arrays.fill(cache,-1);
        int ans2 = helper(Arrays.copyOfRange(nums,1,nums.length),0);
        return Math.max(ans1,ans2);
        
    }
    public int helper(int[] nums, int i) {
        if(i>=nums.length)
        return 0;
        if(cache[i]!=-1);
        else
        cache[i]=Math.max(helper(nums,i+2) + nums[i] , helper(nums,i+1));
        return cache[i];

    }
}
