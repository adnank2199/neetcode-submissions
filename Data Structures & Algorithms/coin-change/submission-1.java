class Solution {
    int[][] cache ;
    public int coinChange(int[] coins, int amount) {
        
        cache=new int[amount+1][coins.length];
        for(int[] i :cache)
        Arrays.fill(i,-1);
        int ans=helper(coins,amount,0) ;return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int helper(int[] coins , int amount , int i) {
        if(amount==0)
        return 0;
        if(amount<0|| i==coins.length)
        return Integer.MAX_VALUE;
        if(cache[amount][i]!=-1)
        return cache[amount][i];


        int take = helper(coins,amount-coins[i],i);
        take = take==Integer.MAX_VALUE ? take : take+1;

        int skip = helper(coins,amount,i+1);
        
        

        return cache[amount][i] = Math.min(take,skip);
    }
}
