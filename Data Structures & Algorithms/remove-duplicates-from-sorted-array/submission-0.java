class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0 ;
        int i=0;
        while(i<nums.length) {
            nums[count]=nums[i];
            count++;
            while(i+1<nums.length && nums[i]==nums[i+1])
            i++;
            i++;
        }
        return count;
    }
}