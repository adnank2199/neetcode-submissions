class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String,ArrayList<String>> h = new HashMap<>();
        for(String s : strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if(h.containsKey(key) ) {
                ArrayList<String> curr = h.get(key);
                curr.add(s);
                h.put(key,curr);
            }
            else {
                ArrayList<String> curr = new ArrayList<>();
                curr.add(s);
                h.put(key,curr);
            }
        }
        return new ArrayList<>(h.values());
    }
}
