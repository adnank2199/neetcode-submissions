class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet <Integer> h = new HashSet<>();
        for (int i : nums) {
            h.add(i);
        }
        int len=0;
        for(int i =0;i<nums.length;i++) {
            int count =0;
            if(h.contains(nums[i]-1)) 
            continue;
            else {
                int seq = nums[i];
                count++;
                while(h.contains(++seq)) {
                  count++;
                }
                if(count > len)
                len=count;
            }
        }
        return len;
    }
}
