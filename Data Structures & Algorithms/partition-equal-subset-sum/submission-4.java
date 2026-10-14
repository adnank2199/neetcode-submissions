class Solution {
    Boolean[][] cache ;
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int i : nums)
        sum+=i;
        if(sum%2 != 0 )
        return false;
        cache = new Boolean[nums.length+1][(sum/2)+1];
        return helper(nums,0,sum/2);
    }

    public boolean helper(int[] nums, int i , int sum ) {
        if(sum==0) 
        return true; 
        
        if(i==nums.length || sum<0 )
        return false; 

        if(cache[i][sum] != null)
        return cache[i][sum];

        

        return cache[i][sum] = helper(nums ,i+1 , sum-nums[i]) || helper(nums,i+1,sum);
    }
}
