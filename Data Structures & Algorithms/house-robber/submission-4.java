class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache=new int[nums.length];
        Arrays.fill(cache,-1);
        return helper(nums,0);
    }

    public int helper(int[] nums , int i) {
        if(i>=nums.length)
        return 0;

        if(cache[i]!=-1);
        else {
            cache[i]= Math.max(helper(nums,i+1) , helper(nums,i+2)+nums[i]);
        }
        return cache[i];
    }
}
