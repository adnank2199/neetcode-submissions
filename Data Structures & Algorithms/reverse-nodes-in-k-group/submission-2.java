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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode oldHead = head ; 
        ListNode newHead = getkth(oldHead,k) ;
        if(newHead == null)
        return oldHead;

        ListNode next = newHead.next ; 
        newHead.next = null;
        rev(oldHead);
        oldHead.next = reverseKGroup(next,k) ;

        return newHead; 

        
    }

    public void rev(ListNode head) {
        ListNode curr = head ; 
        ListNode prev = null ; 

        while(curr!=null) {
            ListNode temp = curr.next; 
            curr.next = prev ; 
            prev = curr ;
            curr = temp;
        } 
    }

    public ListNode getkth(ListNode head , int k) {
        while(k!=1) {
            if(head==null ||head.next == null) 
            return null;
            head = head.next ;
            k--;
        }
        return head;
    }

}
