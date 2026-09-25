class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        // if(cost.length==0)
        // return 0;
        // if(cost.length==1)
        // return cost[0];
        // int a = cost[0];
        // int b = cost[1];
        // for(int i=2 ;i<cost.length ;i++) {
        //     int temp = b;
        //     b = cost[i] + Math.min(a,b);
        //     a=temp;
        // }
        // return Math.min(a,b);
        int[] dp = new int[cost.length + 1];
        dp[0]=0;
        dp[1]=0;
        
        for(int i = 2 ; i <= cost.length ; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]) ;
        }
        return dp[cost.length];
    }

}