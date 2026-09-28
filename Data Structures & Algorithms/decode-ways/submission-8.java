class Solution {
    int[] cache;
    public int numDecodings(String s) {
        cache = new int[s.length()];
        Arrays.fill(cache,-1);
        return helper(s,0);
    }
    public int helper(String s , int i) {
        if(i==s.length())
        return 1;
        if(i>s.length() || s.charAt(i)=='0')
        return 0;
        if(cache[i]!=-1);
        else
        cache[i] = helper(s,i+1) + (i+1 < s.length() && (Integer.parseInt(s.substring(i,i+2)) <= 26) ? helper(s,i+2) : 0);
        return cache[i];
    }
}