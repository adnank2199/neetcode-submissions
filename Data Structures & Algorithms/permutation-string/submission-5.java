class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
        return false;
        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for(int i =0 ; i<s1.length();i++) {
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }

        int matches = 0 ;
        for(int i =0 ; i<26 ;i++) {
            if(a1[i]==a2[i])
            matches++;
        }

        int L = 0 ;
        for(int R = s1.length() ; R < s2.length() ; R++) {
            if(matches == 26) 
            return true;

            int index = s2.charAt(L) - 'a' ;
            a2[index]--;
            if(a1[index]==a2[index])
            matches++;
            else if(a1[index] == a2[index]+1)
            matches--;

            index = s2.charAt(R) - 'a';
            a2[index]++;
            if(a1[index]==a2[index])
            matches++;
            else if(a1[index] == a2[index]-1)
            matches--;
            L++;
        }
        return matches==26;
    }
}
