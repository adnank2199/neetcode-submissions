class Solution {
    Boolean[] cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        cache = new Boolean[s.length()+1];
        Arrays.fill(cache,null);
        return helper(s, wordDict, 0);
    }

    public boolean helper(String s , List<String> wd , int i) {
        if(i == s.length()) 
            return cache[i] = true;
        if(cache[i]!=null)
        return cache[i];
        for(String curr : wd) {
            if(i + curr.length() <= s.length() && curr.equals(s.substring(i, i + curr.length()))) {
                if(helper(s, wd, i + curr.length()))
                    return cache[i] = true;
            }
        }
        return cache[i] = false;
    }
}