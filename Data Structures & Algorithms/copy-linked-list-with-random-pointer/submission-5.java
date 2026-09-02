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
        Node dummy = new Node(0);
        Node curr = dummy;
        Map<Node,Node> h = new HashMap<>();
        while(head!=null) {
            dummy.next = (h.containsKey(head)) ? h.get(head) : new Node(head.val);
            dummy=dummy.next;
            h.put(head , dummy);
            if(head.random == null) dummy.random = null;
            else {
                dummy.random = (h.containsKey(head.random) ) ? h.get(head.random) : new Node(head.random.val);
                h.put(head.random , dummy.random);
            }
            head = head.next;
        }
        return curr.next;
    }
}