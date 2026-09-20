class Solution {
    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(helper(0,n));
    }

    public HashSet<String> helper(int i,int n) {
        if(i==n) {
            HashSet<String> h = new HashSet<>();
            h.add("");
            return h;
        }

        HashSet<String> ans = new HashSet<>();
        HashSet<String> prev = helper(i+1,n);

        for(String s: prev) {
            for(int j =0 ;j<=s.length();j++){
                StringBuilder curr = new StringBuilder(s);
                curr.insert(j,"()");
                ans.add(String.valueOf(curr));
            }
        }
        return ans;
    }
}
