class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> s1 = new HashMap<>();
        HashMap<Character,Integer> t1 = new HashMap<>();
        for(int i =0 ; i < t.length() ; i++) {
            t1.put(t.charAt(i),t1.getOrDefault(t.charAt(i),0)+1);
        }
        if(s.equals(t))
        return s;
        int matches = 0;  
        String res = "";
        int L = 0 , R = 0;
        while(R<s.length()) {
            char curr1 = s.charAt(R);
            if(t1.containsKey(curr1)) {
                s1.put(curr1,s1.getOrDefault(curr1,0)+1);
                if(s1.get(curr1)<=t1.get(curr1))
                matches++;
            }
            R++;
            while(matches==t.length()) {

                char curr=s.charAt(L);
                if(t1.containsKey(curr)) {
                    if(s1.get(curr).equals(t1.get(curr))) {
                        String possibleanswer = s.substring(L,R);
                        if(res.isEmpty())
                        res=possibleanswer;
                        else
                        res= (res.length() > possibleanswer.length()) ? possibleanswer : res ; 
                        matches--;
                    }
                }
                if(s1.containsKey(curr) && s1.get(curr)>1) {
                    s1.put(curr, s1.get(curr)-1);
                }
                else
                s1.remove(curr);
                L++;

            }
        }
        return res;
    }
}