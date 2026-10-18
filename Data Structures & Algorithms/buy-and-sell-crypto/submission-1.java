class Solution {
    public int maxProfit(int[] prices) {
        int L = 0 ;
        int R = 0 ; 
        int max = 0 ;
        while(R!=prices.length) {
            int curr = prices[R] - prices[L];
            if(curr < 0) {
                L=R; 
                R++;
            }
            else {
                max = Math.max(max,curr);
                R++;
            }
        }
        return max;
    }
}
