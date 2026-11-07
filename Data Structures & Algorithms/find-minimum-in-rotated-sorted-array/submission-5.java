public class Solution {
    public int findMin(int[] nums) {
        int L = 0 ;
        int R = nums.length - 1;
        if(nums[L] <= nums[R])
        return nums[0];

        while(L<R) {
            int mid = (L+R)/2;
            if(nums[mid] > nums[L]) 
            L=mid;
            else  
            R=mid;
        }
        return nums[L+1];
    }
}