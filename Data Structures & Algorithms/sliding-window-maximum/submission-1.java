public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0, r = 0;

        while (r < n) {
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.offerLast(r);
            if(r-l+1 == k) {
                int max = nums[q.peekFirst()];
                output[l]=max;
                q.remove(l);
                l++;
            }
            r++;
        }

        return output;
    }
}