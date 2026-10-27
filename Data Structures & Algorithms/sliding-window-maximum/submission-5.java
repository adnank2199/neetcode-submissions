public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int i =0;i<k;i++) {
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) 
            q.pollLast();
            q.offer(i);
        }

        int[] ans = new int[nums.length-k+1];
        int L = 0;
        ans[L] = nums[q.peekFirst()];

        int R = k;
        
        while(R<nums.length) {
            while(!q.isEmpty() && q.peekFirst() == L) 
            q.pollFirst();
            L++; 
            while(!q.isEmpty() && nums[q.peekLast()] < nums[R]) 
            q.pollLast();
            q.offer(R);
            ans[L] = nums[q.peekFirst()];
            R++;
        }

        return ans;
    }
}