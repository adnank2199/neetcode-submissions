class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> a = new HashMap<> ();
        for(int i : nums) {
            if(a.get(i)!=null)
            return true;
            else
            a.put(i,1);
        }
        return false;
    }
}