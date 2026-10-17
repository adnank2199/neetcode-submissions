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
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len==0)
        return null;
        return divide(lists,0,len-1);
    }

    public ListNode divide(ListNode[] lists , int L  , int R) { 
        if(L==R) 
        return lists[L];

        int M = (L+R) / 2 ;

        ListNode a = divide(lists , L , M);
        ListNode b = divide(lists , M+1 , R);

        return merge(a , b);
    }

    public ListNode merge(ListNode a , ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy ;

        while(a!=null || b!=null) {
            if(a==null) {
                curr.next = b ;
                b = b.next;
            }

            else if(b==null) {
                curr.next = a;
                a=a.next;
            }

            else {

                if(a.val > b.val) {
                    curr.next = b;
                    b=b.next;
                }
                else {
                    curr.next = a ;
                    a=a.next;
                }
            }
            curr=curr.next;
        }
        return dummy.next;
    }

}
