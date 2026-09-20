class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return new ArrayList<>(helper(0,nums));
    }

    public HashSet<List<Integer>> helper(int i , int[] nums) {
        if(i==nums.length) {
            HashSet<List<Integer>> h = new HashSet<>();
            h.add(new ArrayList<>());
            return h;
        }

        HashSet<List<Integer>> ans = new HashSet<>();
        HashSet<List<Integer>> curr = helper(i+1,nums);

        for(List<Integer> a : curr) {
            for(int j =0 ;j<=a.size();j++) {
                List<Integer> b = new ArrayList<>(a);
                b.add(j,nums[i]);
                ans.add(b);
            }
        }
        return ans;
    }
}