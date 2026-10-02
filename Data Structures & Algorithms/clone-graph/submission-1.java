/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {

        if(node == null)
        return node ; 

        Queue<Node> q = new ArrayDeque<>();
        Map<Node,Node> m = new HashMap<>() ;
        q.add(node);
        m.put(node,new Node(node.val));

        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node nei : curr.neighbors) {
                if(!m.containsKey(nei)) {
                    m.put(nei,new Node(nei.val));
                    q.offer(nei);
                }
                m.get(curr).neighbors.add(m.get(nei));
            }
        }
        return m.get(node);
    }
}