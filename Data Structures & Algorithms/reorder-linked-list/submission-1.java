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
        ListNode S = head ;
        ListNode dummy = new ListNode(0);
        ListNode F = head.next ; 
        while(F !=null && F.next!=null) {
            S=S.next; 
            F=F.next.next;
        }
        ListNode revHead = S.next ;
        S.next = null;
        revHead = reverse(revHead);
        ListNode itr = head ;
        while(head != null && revHead!=null) {
            ListNode temp1 = head.next ; 
            ListNode temp2 = revHead.next ;
            head.next = revHead ; 
            revHead.next = temp1;
            head = temp1; 
            revHead = temp2;

        }
    }

    public ListNode reverse(ListNode head) {
        if(head==null || head.next == null)
        return head ;

        ListNode newHead = reverse(head.next);
        head.next.next = head ; 
        head.next = null ; 
        return newHead; 
    }
}
