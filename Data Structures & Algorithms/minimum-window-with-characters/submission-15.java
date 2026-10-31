class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) 
        return "" ;

        Map<Character,Integer> s1 = new HashMap<>();
        Map<Character,Integer> t1 = new HashMap<>();

        for(int i = 0 ; i < t.length() ; i++) {
            char tcurr = t.charAt(i);
            t1.put(tcurr,t1.getOrDefault(tcurr,0)+1);
        }

        int L =0 , R = 0 ;
        int matches = 0 ;
        String ans = "" ;

        while(R<s.length()) {
            char curr = s.charAt(R);
            s1.put(curr,s1.getOrDefault(curr,0)+1);

            if(t1.containsKey(curr)) {
                if(t1.get(curr) >= s1.get(curr)) 
                matches++;
            }

            if(matches==t.length()) {
                char c = s.charAt(L);
                while(!t1.containsKey(c) || s1.get(c) > t1.get(c)) {
                    s1.put(c,s1.get(c)-1);
                    L++;
                    c = s.charAt(L);
                }
                if(ans.isEmpty()) {
                    ans = s.substring(L,R+1);
                }
                else if(ans.length() > R-L+1) {
                    ans = s.substring(L,R+1);
                }
                s1.put(c, s1.get(c) - 1);
                L++;
                matches--;
            }
            R++;
        }
        return ans ;
    }
    
}
