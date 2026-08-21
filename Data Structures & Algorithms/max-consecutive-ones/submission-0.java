class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0 ;
        int count = 0; 
        int curr = 0 ;
        while(count < nums.length) {
            if(nums[count]==1) {
                curr++;
                if(curr > max)
                max=curr;
            }
            else
            curr=0;
            count++;
        }
        return max;
    }
}