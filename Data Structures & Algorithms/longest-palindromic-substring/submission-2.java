class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0 ; i < s.length() ; i++) {
            String s1 = helper(s,i,i);
            String s2 = helper(s,i,i+1);
            String s3 = (s1.length() > s2.length() ? s1 : s2);
            ans = (s3.length() > ans.length()) ? s3 : ans;
        }
        return ans;
    }

    public String helper(String s , int L , int R) {
        int start=0 , end=0;
        while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)) {
            if(R-L+1 > end-start+1) {
                start = L ; 
                end = R ; 
            }
            L--;
            R++;
        }
        return s.substring(start,end+1);
    }
}
