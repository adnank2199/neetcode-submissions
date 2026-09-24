class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Boolean> h = new HashMap<>();
        for(int i : nums){
            if(h.containsKey(i))
            return true;
            h.put(i,true);
        }
        return false;
    }
}