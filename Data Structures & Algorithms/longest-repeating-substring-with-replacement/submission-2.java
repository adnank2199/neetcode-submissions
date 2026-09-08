class Solution {
    public int characterReplacement(String se, int k) {
        Map<Character,Integer> h = new HashMap<>() ;
        int L = 0 , R = 0 ;
        char[] s = se.toCharArray();
        int res = 0 ;
        int maxf=0 ;
        while(R<s.length) {
            h.put(s[R] , h.getOrDefault(s[R],0) + 1);
            maxf = Math.max(maxf,h.get(s[R]));
            while(R-L+1 - maxf > k) {
                h.put(s[L] , h.get(s[L]) - 1);
                L++;
            }
            res = Math.max(res, R-L+1);
            R++;
        }
        return res;
        //redo in the morning 
    }
}
