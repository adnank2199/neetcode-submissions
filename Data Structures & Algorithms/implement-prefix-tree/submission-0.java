class TrieNode {
    Map<Character,TrieNode> children = new HashMap<>();
    boolean word;
}

class PrefixTree {
    TrieNode root ;
    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode curr = this.root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return false;
            }
            curr=curr.children.get(c);
        }
        return curr.word;
    }

    public boolean startsWith(String word) {
        TrieNode curr = this.root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return false;
            }
            curr=curr.children.get(c);
        }
        return true;
    }
}
