/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode () {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode f = head.next;
        ListNode s = head;
        while (f != null && f.next != null) {
            if (s == f)
                return true;
            s = s.next;
            f = f.next.next;
        }
        return false;
    }
}