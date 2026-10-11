class Solution {
    Set<String> visited = new HashSet<>();
    Map<String,List<String>> adj = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
        return 0;

        for(String word : wordList) {
            for(int i =0 ; i<word.length();i++) {
                StringBuilder s = new StringBuilder(word);
                s.setCharAt(i,'*');
                String node = s.toString();
                if(!adj.containsKey(node))
                adj.put(node,new ArrayList<>());
                adj.get(node).add(word);
            }
        }      
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int len = 0 ;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int j =0;j<size;j++) {
                String word = q.poll();
                if(word.equals(endWord))
                return len+1;
                for(int i =0;i<word.length();i++) {
                    StringBuilder s = new StringBuilder(word);
                    s.setCharAt(i,'*');
                    String node = s.toString();
                    if(adj.containsKey(node)) {
                        for(String words : adj.get(node)) {
                            if(!visited.contains(words))
                            q.offer(words);
                            visited.add(words);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }

    
}
