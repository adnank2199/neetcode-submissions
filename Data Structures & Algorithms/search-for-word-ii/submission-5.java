class Solution {
    List<Integer> ans = new ArrayList<>();
    class TrieNode {
        Map<Character,TrieNode> children = new HashMap<>();
        boolean word ; 
        int index; 
    }

    class PrefixTree {
        TrieNode root ; 
        
        public PrefixTree() {
            this.root = new TrieNode();
        }

        public void insert(String word ,int index) {
            TrieNode curr = this.root;
            for(char c : word.toCharArray()) {
                if(!curr.children.containsKey(c)) {
                    curr.children.put(c,new TrieNode());
                }
                curr=curr.children.get(c);
            }
            curr.word = true;
            curr.index = index;
        }

        public List<Integer> search(char[][]board) {
            for(int i = 0 ;i<board.length;i++)
            for(int j =0;j<board[0].length;j++)
            helper(board,i,j,this.root);
            return ans;
        }

        public void helper(char[][]board , int i , int j , TrieNode curr) {

            if(curr.word==true && curr.index!=-1)
            {ans.add(curr.index); curr.index=-1;}
            if(Math.min(i,j) < 0 || i==board.length || j==board[0].length || board[i][j] == '0')
            return;

            

            char current = board[i][j];
            if(!curr.children.containsKey(current))           
            return;

            board[i][j]='0';
                helper(board,i+1,j,curr.children.get(current));
                helper(board,i-1,j,curr.children.get(current));
                helper(board,i,j+1,curr.children.get(current));
                helper(board,i,j-1,curr.children.get(current));
            board[i][j]=current;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        PrefixTree helper = new PrefixTree();
        for(int i =0;i<words.length;i++){
            helper.insert(words[i],i);
        }

        List<Integer> indexes = helper.search(board);

        List<String> anss = new ArrayList<>();

        for(int i : indexes) {
            anss.add(words[i]);
        }

        return anss;

    }

    
}
