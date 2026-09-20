class Solution {
    private List<List<String>> ans = new ArrayList<>();
    private List<String> curr = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(0,0,s);
        return ans;
    }

    public void helper(int i , int j , String s) {
        if(i==s.length()) {
            if(j==i) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if(check(s.substring(j,i+1))) {
            curr.add(s.substring(j,i+1));
            helper(i+1,i+1,s);
            curr.remove(curr.size()-1);
        }

        helper(i+1,j,s);

    }

    public boolean check(String s) {
        int i =0 ;
        int j = s.length()-1;

        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) 
            return false;
            i++;
            j--;
        }
        return true;
    }
}