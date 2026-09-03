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
    public int pairSum(ListNode head) {
        int sum = 0;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode rev = slow;
        rev=reverse(rev);
        while(head!=slow) {
            int val = head.val + rev.val;
            sum = Math.max(val , sum);
            head=head.next;
            rev=rev.next;
        }
        return sum;
    }
    public ListNode reverse(ListNode head) {
        ListNode curr = head ; 
        ListNode prev = null ;
        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next;
        }
        return prev;
    }
}