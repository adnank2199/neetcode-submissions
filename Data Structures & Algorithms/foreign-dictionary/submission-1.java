class Solution {
    Set<Character> visited ;
    Set<Character> path ;
    Map<Character, Set<Character>> adj;
    StringBuilder ans;
    public String foreignDictionary(String[] words) {
        int i = 0;
        int j = 1;

        visited = new HashSet<>();
        path = new HashSet<>();


        Set<Character> chars = new HashSet<>();

        adj = new HashMap<>();

        for(String word : words) {
            for(char ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new HashSet<>());
                chars.add(ch);
            }
        }

        while(i < words.length - 1) {
            String a = words[i];
            String b = words[j];

            if(!valid(a, b))
                return "";

            int c = index(a, b);

            if(c != -1) {
                adj.get(a.charAt(c)).add(b.charAt(c));
            }

            i++;
            j++;
        }

        ans = new StringBuilder();

        for(char c : chars) {
            if(!topo(c))
            return "";

        }

        return ans.reverse().toString();
    }

    public boolean valid(String a, String b) {
        int i = 0;

        while(i < a.length() && i < b.length()) {
            if(a.charAt(i) != b.charAt(i))
                return true;

            i++;
        }

        return a.length() <= b.length();
    }

    public int index(String a, String b) {
        int i = 0;

        while(i < a.length() && i < b.length()) {
            if(a.charAt(i) != b.charAt(i))
                return i;

            i++;
        }

        return -1;
    }

    public boolean topo(Character c) {
        if(path.contains(c))
        return false;
        if(visited.contains(c)) 
        return true;

        
        path.add(c);

        for(char i : adj.get(c)) {
            if(!topo(i))
            return false;
        }

        path.remove(c);
        ans.append(c);
        visited.add(c);
        return true;
    }
}