class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1; int[] B = nums2;
        // if(nums1.length > nums2.length) 
        // {A = nums2; B = nums1;}

        int Alen = A.length;
        int Blen = B.length;

        int half = (Alen + Blen)/2;

        int L = 0 , R = A.length;

        while(L<=R) {
            int i = (L+R)/2;
            int j = half - i;

            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright) {
                if((Alen+Blen)%2!=0) 
                return Math.min(Aright,Bright);
                else 
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            }
            else if (Aleft > Bright) 
                R = i - 1;
            else 
                L = i + 1;
        }
    return 0.0;
    }
}
