class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==0)
        return 0;
        if(cost.length==1)
        return cost[0];
        int a = cost[0];
        int b = cost[1];
        for(int i=2 ;i<cost.length ;i++) {
            int temp = b;
            b = cost[i] + Math.min(a,b);
            a=temp;
        }
        return Math.min(a,b);
    }

}
