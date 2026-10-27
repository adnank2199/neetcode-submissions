class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int end = 0 ;
        int start = gas.length - 1;
        int total = gas[start]-cost[start];
        while(start>end) {
            if(total < 0) {
                start--;
                total+=gas[start]-cost[start];
            }
            else {

                total+=gas[end]-cost[end];
                                end++;
            }
        }
        return total>=0 ? start : -1;

    }
}
