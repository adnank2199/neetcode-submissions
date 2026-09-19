class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>() ;
        List<Integer> curr = new ArrayList<>();
        helper(0,nums,ans,curr,target);
        return ans;
    }

    public void helper(int i , int[] nums , List<List<Integer>> ans, List<Integer> curr, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i == nums.length || target < 0) {
            return;
        }

        curr.add(nums[i]);
        helper(i, nums, ans, curr, target - nums[i]);
        curr.remove(curr.size()-1);
        helper(i+1, nums, ans, curr, target);
    }
}