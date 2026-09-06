class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        int index = 0;
        while(l<=r) {
            if(nums[l] <= nums[r]) {
                index = (nums[index] > nums[l]) ? l : index;
            }
            int mid = l + (r-l)/2;
            index = (nums[index] > nums[mid]) ? mid : index;
            if(nums[l] <= nums[mid])
            l = mid +1 ;
            else 
            r = mid -1 ;
        }

        if(target >= nums[index] && target <= nums[nums.length-1])
        {
            l = index ; 
            r = nums.length - 1;
        }
        else {
            l=0;
            r=index-1;
        }
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(nums[mid]==target)
            return mid;
            if(nums[mid] < target) {
                l=mid+1;
            }
            else
            r=mid-1;
        }
        return -1;
    }
}
