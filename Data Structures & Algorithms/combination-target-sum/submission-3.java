class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>() ;
        List<Integer> curr = new ArrayList<>();
        helper(0,nums,ans,curr,target,0);
        return ans;
    }

    public void helper(int i , int[] nums , List<List<Integer>> ans, List<Integer> curr, int target , int total) {
        if(target==total) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(total>target)
        return;

        for(int j = i ; j < nums.length ;j++) {
            curr.add(nums[j]);
            helper(j,nums,ans,curr,target,total+nums[j]);
            curr.remove(curr.size()-1);
        }
    }
}