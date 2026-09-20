class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(0,nums);
    }

    public List<List<Integer>> helper(int i , int[] nums) {
        if(i==nums.length) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }

        List<List<Integer>> ans=new ArrayList<>();
        List<List<Integer>> curr = helper(i+1,nums);

        for(List<Integer> a : curr) {
            for(int j = 0;j<=a.size() ;j++) {
                List<Integer> b = new ArrayList<>(a);
                b.add(j,nums[i]);
                ans.add(b);
            }
        }
        return ans;
    }
}
