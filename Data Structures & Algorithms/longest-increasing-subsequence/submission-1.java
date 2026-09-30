class Solution {
    int[][] cache ;
    public int lengthOfLIS(int[] nums) {
        cache = new int[nums.length][nums.length+1];
        for(int i =0 ;i<nums.length;i++)
        Arrays.fill(cache[i],-1);
        return helper(nums,0,-1);
    }

    public int helper(int[] nums , int i , int j) {
        if(i==nums.length) {
            return 0;
        }
        if(j!=-1 && cache[i][j+1] != -1) {
            return cache[i][j+1];
        }
        int len =0;
        if(j==-1 || nums[i] > nums[j]) {
            len = 1 + helper(nums,i+1,i);
        }
        
        return cache[i][j+1] = Math.max(len,helper(nums,i+1,j));
    }
}
