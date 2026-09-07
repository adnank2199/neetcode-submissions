class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a ;
         int[] b;
        if(nums1.length <= nums2.length) {
            a=nums1;
            b=nums2;
        }
        else {
            a=nums2;
            b=nums1;
        }

        int l = -1 ;
        int r = a.length - 1 ;
        int size = a.length + b.length;
        int psize = size/2;

        while(true) { 
            int mida = (l +r)/2;
            int midb =  psize - mida -2 ; //because we have to do zero indexing 
            
            int aleft = (mida < 0) ? Integer.MIN_VALUE : a[mida];
            int aright = (mida+1 == a.length) ? Integer.MAX_VALUE : a[mida+1];
            int bleft = (midb < 0) ? Integer.MIN_VALUE : b[midb];
            int bright = (midb+1 == b.length) ? Integer.MAX_VALUE : b[midb+1]; 

            if(aleft <= bright && aright >= bleft){
                if(size%2==0) {
                    return (double)(Math.max(aleft , bleft) + Math.min(aright , bright))/2.0;
                }
                else {
                    return Math.min(aright,bright);
                }
            }

            if(aleft > bright) 
            r=mida -1 ;
            else 
            l = mida+1;
        }
    }
}
