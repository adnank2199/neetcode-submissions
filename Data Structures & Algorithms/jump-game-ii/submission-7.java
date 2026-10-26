class Solution {
    int[] cache;
    public int jump(int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache,-1);
        return helper(nums,0);
    }

    public int helper(int[] nums , int i) {
        if(i==nums.length-1)
        return 0;
        if(cache[i] != -1)
        return cache[i];
        int min = Integer.MAX_VALUE-1000;
        for(int j=1;j<=nums[i];j++)
        if(i+j<nums.length)
        min = Math.min(helper(nums,i+j) + 1 , min);
        cache[i]=min;
        return cache[i];
    }
}
