class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A =  nums1 ;
        int[] B =  nums2 ;

        int Alen = A.length ;
        int Blen = B.length ;
        int size = Alen + Blen;
        int half = size / 2 ;
        
        int L = 0 ; 
        int R = Alen;

        while(L<=R) {
            int i = (L+R)/2 ;
            int j = half - i ;

            int Aleft = (i-1>=0) ? A[i-1] : Integer.MIN_VALUE;
            int Aright = (i<Alen) ? A[i] : Integer.MAX_VALUE;
            int Bleft = (j-1>=0) ? B[j-1] : Integer.MIN_VALUE;
            int Bright = (j<Blen) ? B[j] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright) {
                if(size%2 !=0) 
                return Math.min(Aright,Bright);
                else 
                return (Math.max(Aleft,Bleft) + Math.min(Aright,Bright))/2.0;
            }
            else if(Aleft > Bright) 
            R=i-1;
            else 
            L=i+1;
        }
        return 0.0;
    }
}
