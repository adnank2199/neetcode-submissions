class Solution {
    public int characterReplacement(String se, int k) {
        Map<Character,Integer> h = new HashMap<>();
        int L = 0 , R = 0 ;
        int res = 0 ; 
        int maxf = 0 ;

        while(R<se.length()) {
            h.put(se.charAt(R),h.getOrDefault(se.charAt(R),0) + 1);
            maxf = Math.max(maxf,h.get(se.charAt(R)));

            while(R-L+1 - maxf > k) {
                h.put(se.charAt(L),h.getOrDefault(se.charAt(L),0)-1);
                L++;
            }

            res = Math.max(res, R-L+1);
            R++;
        }

        return res;
    }
}
