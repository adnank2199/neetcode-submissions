class Solution {
    public int lengthOfLongestSubstring(String se) {
        Set<Character> s = new HashSet<>();
        char[] c = se.toCharArray();
        int L = 0 , R = 0 ;
        int len = 0 ; 
        int max = 0;
        while(R<c.length) {
            while(s.contains(c[R])) {
                s.remove(c[L]);
                L++;
            }
            s.add(c[R]);
            len = R - L + 1 ; 
            max = Math.max(len , max);
            R++;
        }
        return max ;
    }
}
