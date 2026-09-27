class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        return nums[0];
        return Math.max(helper(Arrays.copyOfRange(nums,0,nums.length-1)),helper(Arrays.copyOfRange(nums,1,nums.length)));
        
    }
    public int helper(int[] nums) {
        // if(i>=nums.length)
        // return 0;
        // if(cache[i]!=-1);
        // else
        // cache[i]=Math.max(helper(nums,i+2) + nums[i] , helper(nums,i+1));
        // return cache[i];

        if(nums.length == 0) 
        return 0 ; 
        if(nums.length == 1) 
        return nums[0] ; 

        int a = nums[0];
        int b = Math.max(nums[0],nums[1]);

        for(int i =2 ; i < nums.length ; i++) {
            int temp  = b ;
            b = Math.max(nums[i] + a , b);
            a = temp ;
        }
        return b;

    }
}
