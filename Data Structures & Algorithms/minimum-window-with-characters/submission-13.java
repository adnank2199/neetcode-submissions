class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) 
        return "";
        Map<Character,Integer> s1 = new HashMap<>();
        Map<Character,Integer> t1 = new HashMap<>();

        for(int i = 0 ; i < t.length() ; i++) {
            s1.put(s.charAt(i) , s1.getOrDefault(s.charAt(i),0)+1);
            t1.put(t.charAt(i) , t1.getOrDefault(t.charAt(i),0)+1);
        }

        int matches = 0;
for (Map.Entry<Character, Integer> e : t1.entrySet()) {
    matches += Math.min(
        s1.getOrDefault(e.getKey(), 0),
        e.getValue()
    );
}



        int L = 0 ; 
        int R = t.length() ;

        String ans="" ;

        if (matches == t.length())
            return s.substring(0, t.length());

        while(R < s.length()) {
            char curr = s.charAt(R);
            s1.put(curr , s1.getOrDefault(curr,0) + 1);

            if(t1.containsKey(curr) && s1.get(curr) <= t1.get(curr)) 
            matches++;

            if(matches == t.length()) {
                char c = s.charAt(L);
                while(!t1.containsKey(c) || s1.get(c) > t1.get(c)) {
                    s1.put(c,s1.get(c)-1);
                    L++;
                    c=s.charAt(L);
                }

                if(ans.isEmpty()) 
                ans = s.substring(L,R+1);

                else if(R-L+1 < ans.length()) {
                    ans = s.substring(L,R+1);
                }
                s1.put(c,s1.get(c)-1);
                L++;
                if (s1.get(c) < t1.get(c)) {
                    matches--;
                }
        }
            R++;
        } 

        return ans;
    }
}