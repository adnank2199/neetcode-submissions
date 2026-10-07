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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode itr = dummy;
        int carry = 0 ;
        int sum ;
        while(l1!= null || l2!=null ||carry!=0){
            if(l1==null && l2==null) {
                sum=carry;
                itr.next = new ListNode(sum);
                break;
            }
            else if(l1==null) {
                sum = l2.val + carry ;
            }
            else if(l2==null) {
                sum = l1.val + carry ;
            }
            else {
                sum = l1.val + l2.val + carry ; 
            }
            carry = sum/10;
            sum=sum%10;
            itr.next = new ListNode(sum);
            itr=itr.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }

        return dummy.next;
    }

}

