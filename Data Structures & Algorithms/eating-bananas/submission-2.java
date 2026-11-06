class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = Integer.MAX_VALUE; 
        int L = 1 ;
        int R = Integer.MIN_VALUE;
        for(int i : piles) {
            R=Math.max(R,i);
        }

        while(L<=R) {
            int mid = L+(R-L)/2 ;
            long hrs = 0;
            for(int i : piles) {
                if(i%mid!=0)
                hrs++;
                hrs+=i/mid; 
            }
            if(hrs > h) {
                L = mid + 1 ;
            }
            else {
                R=mid-1; 
                min = Math.min(min,mid);
            }
        }
        return min;
    }
}
