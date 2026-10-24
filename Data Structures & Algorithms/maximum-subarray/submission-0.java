class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int i : nums) {
            curr = (curr<0) ? 0+i : curr+i;
            max = Math.max(curr,max);
        }
        return max;
    }
}
