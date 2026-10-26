class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) 
        return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for(int i =0 ;i<s1.length() ; i++) {
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for(int i=0 ; i<26;i++){
            if(f1[i]==f2[i])
            matches++;
        }

        int L = 0;
        for(int R = s1.length() ; R<s2.length() ;R++) {
            if(matches==26) 
            return true;

            f2[s2.charAt(L) - 'a']--;
            if(f2[s2.charAt(L) - 'a'] == f1[s2.charAt(L) - 'a'])
            matches++;
            else if(f2[s2.charAt(L) - 'a'] + 1  == f1[s2.charAt(L) - 'a'])
            matches--;

            f2[s2.charAt(R)-'a']++;
            if(f2[s2.charAt(R)-'a'] == f1[s2.charAt(R)-'a'])
            matches++;
            else if(f2[s2.charAt(R)-'a'] - 1 == f1[s2.charAt(R)-'a'])
            matches--;

            L++;
        }

        return matches==26;
    }
}