class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] freq ;
        Map<String,List<String>> h = new HashMap<>();
        for(String s : strs) {
            freq = new int[26];
            for(int i =0 ; i <s.length();i++) {
                freq[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(freq);
            h.putIfAbsent(key,new ArrayList<>());
            h.get(key).add(s);
        }
        return new ArrayList<>(h.values());
    }
}
