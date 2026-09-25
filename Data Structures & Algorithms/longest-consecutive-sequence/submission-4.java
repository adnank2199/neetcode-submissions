class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> h = new HashMap<>();
        int ans = 0 ;
        for(int i : nums) {
            if(!h.containsKey(i)){h.put(i, 1 + h.getOrDefault(i-1,0) + h.getOrDefault(i+1,0));
            h.put(i-h.getOrDefault(i-1,0),h.get(i));
            h.put(i+h.getOrDefault(i+1,0),h.get(i));
            ans = Math.max(ans,h.get(i));}
        }
        return ans;
    }
}
