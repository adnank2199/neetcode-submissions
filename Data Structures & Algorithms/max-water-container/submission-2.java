class Solution {
    public int maxArea(int[] h) {
        int L = 0 ;
        int R = h.length-1;
        int max = 0;
        while(L<R) {
            max = Math.max(max , Math.min(h[L],h[R]) * (R-L));
            if(h[L] >h[R]) 
            R--;
            else 
            L++;
        }
        return max;
    }
}