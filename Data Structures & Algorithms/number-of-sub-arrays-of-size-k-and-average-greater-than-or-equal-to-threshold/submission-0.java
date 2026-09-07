class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int L = 0 ; 
        int R = 0 ;
        double sum = 0 ;
        int count = 0 ;
        for(R=0;R<arr.length;R++) {
            if(R-L+1 > k)
            {
                count = ((double)sum/k >= (double)threshold) ? count+1 : count;
                sum-=(double)arr[L];
                L++;
            }
            sum+=arr[R];
            if(R==arr.length-1) {
                count = ((double)sum/k >= (double)threshold) ? count+1 : count;
            }
        }
        return count;
    }
}