class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap <Integer, Integer> h = new HashMap<>();
        int res=0;
        for(int i : nums){
            if(!h.containsKey(i)) {
                h.put(i , h.getOrDefault(i-1,0) + h.getOrDefault(i+1,0) + 1 );
                h.put(i- h.getOrDefault(i-1,0) , h.get(i) );
                h.put(i +h.getOrDefault(i+1,0) , h.get(i) );
                res = Math.max(res,h.get(i));
            }
        }
        return res;
    }
}
