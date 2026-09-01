/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dc = null;
        Node ans = null;
        Node it = head ;
        Map<Node, Node> h = new HashMap<>();
        while(it!=null) {
            if(dc == null) {
                dc = new Node(it.val);
                h.put(it, dc);
                it=it.next;
                ans = dc ;
                
            }
            else {
                Node temp = new Node(it.val);
                h.put(it, temp);
                dc.next = temp ; 
                dc = temp ;
                it=it.next;
                
            }
        }
        dc = ans ; 
        it = head ;
        while(it!=null) {
            if(it.random == null) {
                dc.random = null;
            }
            else {
                dc.random = h.get(it.random);
            }
            it=it.next;
            dc=dc.next;
        }
        return ans;
    }
}