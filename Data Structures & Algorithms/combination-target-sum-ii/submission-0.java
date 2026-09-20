class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,target,ans,curr);
        return ans;
    }

    public void helper(int i , int[] candidates , int target , List<List<Integer>> ans , List<Integer> curr) {
        if(target==0) {
            ans.add(new ArrayList<>(curr));
            return;
        } 
        if(i==candidates.length || target<0) 
        return;

        curr.add(candidates[i]);
        helper(i+1,candidates,target-candidates[i],ans,curr);
        curr.remove(curr.size()-1);
        while(i+1<candidates.length && candidates[i]==candidates[i+1])
        i++;
        helper(i+1,candidates,target,ans,curr);
    }
}
