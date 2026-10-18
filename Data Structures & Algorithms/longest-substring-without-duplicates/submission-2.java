class Solution {
    public int lengthOfLongestSubstring(String se) {
        int L = 0 ;
        int R = 0 ;
        Set<Character> subs = new HashSet<>();
        int max = 0;
        while(R!=se.length()) {
            if(subs.contains(se.charAt(R))) {
                subs.remove(se.charAt(L));
                L++;
            }
            else {
                subs.add(se.charAt(R));
                max= Math.max(max , R-L+1);
                R++;
            }
        }
        return max;
    }
}
