/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode s = head ;
        ListNode f = head.next ;
        while(f!=null && f.next!=null) {
            s=s.next;
            f=f.next.next;
        }
        ListNode rev = reverse(s.next);
        s.next=null;
        ListNode curr = head ; 
        while(curr!=null && rev!=null) {
            ListNode temp = curr.next ; 
            ListNode temp2 = rev.next ;
            curr.next = rev;
            rev.next = temp;
            curr=temp;
            rev=temp2;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null ; 
        ListNode curr = head ;
        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
