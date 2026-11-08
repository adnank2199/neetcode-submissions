class Solution {
    public int search(int[] nums, int target) {
        int L = 0 ; 
        int R = nums.length-1;

        if(nums[L] > nums[R]) {
            while(L<R) {
                int mid = (L+R)/2;
                
                if(nums[mid] > nums[R]) 
                L=mid+1;
                else 
                R=mid;
            }

            if(nums[0] > target) {
                R = nums.length-1;
            } 
            else {
                R = L-1 ;
                L = 0 ;
            }
        }

    

        while(L<=R) {
            int mid = (L+R)/2;
                
            if(nums[mid] > target) 
            R=mid-1;
            else if (nums[mid] < target) 
            L=mid+1;
            else 
            return mid;
        }
        
        return -1 ; 
    }
}
