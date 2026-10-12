class TrieNode {
    Map<Character,TrieNode> children = new HashMap<>();
    boolean word;
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                curr.children.put(c,new TrieNode());
            }
            curr=curr.children.get(c);
        }
        curr.word=true;
    }

    public boolean search(String word) {
        return helper(word,0,this.root);
    }

    public boolean helper(String word, int i , TrieNode curr) {
        if (i == word.length()) {
            return curr.word;
        }
        
        if(word.charAt(i) == '.') {
            List<Map.Entry<Character,TrieNode>> children = new ArrayList<>(curr.children.entrySet());
            for(Map.Entry<Character,TrieNode> e : children) {
                if(helper(word,i+1,e.getValue()))
                return true;
            }
            return false;
        }

        else if(curr.children.containsKey(word.charAt(i))) {
            return helper(word,i+1,curr.children.get(word.charAt(i)));
        }

        else {
            return false;
        }

    }
}