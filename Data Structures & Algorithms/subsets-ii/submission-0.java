class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(0,nums,ans,curr);
        return ans;
    }

    public void helper(int i , int[] nums, List<List<Integer>> ans , List<Integer> curr) {
        if(i==nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        helper(i+1,nums,ans,curr);
        curr.remove(curr.size()-1);
        while(i+1!=nums.length && nums[i+1]==nums[i]) {
            i++;
        }
        helper(i+1,nums,ans,curr);
    }
}
