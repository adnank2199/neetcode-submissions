class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(1,ans,curr,n,k);
        return ans;
    }

    public void helper(int i , List<List<Integer>> ans , List<Integer> curr , int n , int k) {
        if(curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i>n) 
        return;

        curr.add(i);
        helper(i+1,ans,curr,n,k);
        curr.remove(curr.size()-1);
        helper(i+1,ans,curr,n,k);
    }
}