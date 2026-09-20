class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        helper(0,0,n,ans,curr);
        return ans;
    }

    public void helper(int o,int c,int n, List<String> ans, StringBuilder curr) {
        if(o==c && o==n) {
            ans.add(curr.toString());
            return;
        }

        if(o < n) {
            curr.append("(");
            helper(o+1,c,n,ans,curr);
            curr.deleteCharAt(curr.length()-1);
        }
        
        if(c < o) {
            curr.append(")");
            helper(o,c+1,n,ans,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
