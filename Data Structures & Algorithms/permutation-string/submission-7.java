class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
        return false;
        Map<Character,Integer> h1 = new HashMap<>();
        Map<Character,Integer> h2 = new HashMap<>();

        int matches = 0 ;

        for(int i = 0 ; i< s1.length() ;i++) {
            h1.put(s1.charAt(i) , h1.getOrDefault(s1.charAt(i),0)+1);
            h2.put(s2.charAt(i) , h2.getOrDefault(s2.charAt(i),0)+1);

        }

        for(char c = 'a'; c <= 'z'; c++) {
    if(h1.getOrDefault(c, 0).equals(h2.getOrDefault(c, 0)))
        matches++;
}

        int L = 0 ; 

        for(int R = s1.length() ; R < s2.length() ; R++) {
            if(matches==26)
            return true;

            h2.put(s2.charAt(L) , h2.get(s2.charAt(L))-1);
            if(h2.get(s2.charAt(L)).equals( h1.getOrDefault(s2.charAt(L),0)))
            matches++;
            if(h2.getOrDefault(s2.charAt(L),0)+1==( h1.getOrDefault(s2.charAt(L),0)))
            matches--;

            h2.put(s2.charAt(R) , h2.getOrDefault(s2.charAt(R),0) +1);
            if(h2.get(s2.charAt(R)).equals(h1.getOrDefault(s2.charAt(R),0)))
            matches++;
            if(h2.getOrDefault(s2.charAt(R),0)-1==h1.getOrDefault(s2.charAt(R),0))
            matches--;

            L++;
        }

        return matches==26;
    }
}
