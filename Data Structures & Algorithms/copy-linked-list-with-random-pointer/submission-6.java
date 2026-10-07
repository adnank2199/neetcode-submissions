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
        Node dummy = new Node(-1);
        Node newhead = dummy;
        Map<Node,Node> mapping = new HashMap<>();
        while(head!=null) {
            Node curr = mapping.containsKey(head) ? mapping.get(head) : new Node(head.val);
            mapping.put(head,curr);
            if(head.next!=null) {
            curr.next = mapping.containsKey(head.next) ? mapping.get(head.next) : new Node(head.next.val);
            mapping.put(head.next , curr.next);
            }
            if(head.random != null) 
            {curr.random = mapping.containsKey(head.random) ? mapping.get(head.random) : new Node(head.random.val);mapping.put(head.random , curr.random);}
            else 
            curr.random = null;
            head=head.next;
            newhead.next=curr;
            newhead=newhead.next;
        }
        return dummy.next;
    }
}