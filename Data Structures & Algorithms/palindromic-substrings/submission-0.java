class Solution {
    public int countSubstrings(String s) {
        int count = 0 ;
        for(int i =0 ;i<s.length() ;i++) {
            count+=helper(s,i,i);
            count+=helper(s,i,i+1);
        }
        return count;
    }

    public int helper(String s , int L , int R) {
        int count=0;
        while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)) {
            count++;
            L--;
            R++;
        }
        return count;
    }
}
