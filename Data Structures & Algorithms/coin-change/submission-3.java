class Solution {
    int[] cache ;
    public int coinChange(int[] coins, int amount) {
        
        cache=new int[amount+1];
        Arrays.fill(cache,-1);
        int ans=helper(coins,amount) ;return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int helper(int[] coins , int amount) {
        if(amount==0)
        return 0;
        if(amount<0)
        return Integer.MAX_VALUE;
        if(cache[amount]!=-1)
        return cache[amount];
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int take = helper(coins,amount-coin);
            if(take!=Integer.MAX_VALUE) 
            min = Math.min(take+1,min);
        }        
        

        return cache[amount] = min;
    }
}
