class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int i : nums)
        sum+=i;
        if(sum%2 != 0 )
        return false;
        return helper(nums,0,sum/2);
    }

    public boolean helper(int[] nums, int i , int sum ) {
        if(sum==0) 
        return true; 
        
        if(i==nums.length )
        return false; 

        return helper(nums ,i+1 , sum-nums[i]) || helper(nums,i+1,sum);
    }
}
