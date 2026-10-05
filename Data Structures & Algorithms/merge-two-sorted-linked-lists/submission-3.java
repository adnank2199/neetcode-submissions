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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) 
        return list1; 

        ListNode mergedLists;
        ListNode chosen ; 

        if(list1==null) {
            mergedLists = mergeTwoLists(list1, list2.next); 
            chosen = list2; 
        }
        else if(list2==null) {
            mergedLists = mergeTwoLists(list1.next , list2);
            chosen = list1;
        }
        else {
            mergedLists = (list1.val > list2.val) ? mergeTwoLists(list1,list2.next) : mergeTwoLists(list1.next , list2);
            chosen = (list1.val > list2.val) ? list2 : list1;
        } 

        chosen.next = mergedLists;
        return chosen ;
        
        
    }
}