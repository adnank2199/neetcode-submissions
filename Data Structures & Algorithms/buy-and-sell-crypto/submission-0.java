class Solution {
    public int maxProfit(int[] prices) {
        int L = 0 ; 
        int R = 0 ;
        int profit =0;
        while(R!=prices.length) {
            int curr = prices[R]- prices[L];
            if(curr < 0) {
                L=R;
                R++;
            }
            else {
                profit = Math.max(profit , curr);
                R++;
            }
            
        }
        return profit;
    }
}
