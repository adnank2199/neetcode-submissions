class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        return false;
        if(s=="")
        return true;
        Map<Character,Integer> se = new HashMap<>();
        Map<Character,Integer> te = new HashMap<>();

        for(int i =0 ; i < s.length() ;i++) {
            se.put(s.charAt(i),se.getOrDefault(s.charAt(i),0)+1);
            te.put(t.charAt(i),te.getOrDefault(t.charAt(i),0)+1);
        }

        return se.equals(te);
    }
}
