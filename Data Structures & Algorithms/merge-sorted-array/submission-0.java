class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1 ;
        int j = n - 1 ;
        int k = m + n - 1 ;

        while(k>-1) {
            if(i<0) 
            nums1[k--]=nums2[j--];
            else if(j<0)
            nums1[k--]=nums1[i--];
            else {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                nums1[i]=0;
                i--;
                k--;
            }
            else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }}
        }
    }
}