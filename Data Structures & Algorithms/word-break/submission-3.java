class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[s.length()] = true;

        for(int i = s.length()-1 ; i>=0 ; i--) {
            for(String curr : wordDict) {
                if(i+curr.length() <= s.length() && curr.equals(s.substring(i,i+curr.length()))) 
                dp[i]= dp[i+curr.length()];
                if(dp[i])
                break;
            }
        }
        return dp[0];
    }
}