class Solution {
    public String longestPalindrome(String s) {
        int[] len = {0,0} ;
        for(int i = 0 ; i < s.length() ; i++) {
             int[] a1 = helper(s,i,i);
             int[] a2 = helper(s,i,i+1);
            int[] a3 = (a1[1] - a1[0] + 1) > (a2[1] - a2[0] + 1) ? a1 : a2;
            len = (len[1] - len[0] + 1 > a3[1] - a3[0] +1 ) ? len : a3;
        }
        return s.substring(len[0] , len[1] + 1);
    }

    public int[] helper(String s , int L , int R) {
        int start=0 , end=0;
        while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)) {
            if(R-L+1 > end-start+1) {
                start = L ; 
                end = R ; 
            }
            L--;
            R++;
        }
        return new int[] {start,end};
    }
}
