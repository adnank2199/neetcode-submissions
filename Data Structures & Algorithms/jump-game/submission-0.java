class Solution {
    public boolean canJump(int[] nums) {
        int index = nums.length - 1; 
        while(index != 0) {
            for(int i = index - 1; i>-1 ; i--) {
                if(i + nums[i] >= index) {
                    index = i ;
                    continue;
                } 
            }
            if(index!=0)
            return false;
        }
        return true;
    }
}
