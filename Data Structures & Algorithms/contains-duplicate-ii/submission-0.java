class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int L = 0 ;
        int R = 0;
        Set<Integer> s = new HashSet<>();
        while(L< nums.length && R< nums.length) {
            if(R - L > k)
            {
                s.remove(nums[L]);
                L++;
            }
            if(s.contains(nums[R]))
            return true;
            s.add(nums[R]);
            R++;
        }
        return false;
    }
}
