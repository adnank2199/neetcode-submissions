public class ListNode { 
    int val; 
    int key;
    ListNode next;
    ListNode prev;

    ListNode(int key , int val) { 
        this.val = val ; 
        this.key = key ; 
        this.next = null ; 
        this.prev = null ;
    }
}


class LRUCache {
    Map<Integer , ListNode > h;
    ListNode right ;
    ListNode left ;
    int cap;

    public void insert(ListNode head) {
        ListNode prev = right.prev;
        prev.next = head ;
        head.prev = prev;
        head.next = right ;
        right.prev = head;
    }

    public void remove(ListNode head) {
        ListNode prev = head.prev;
        ListNode next = head.next;
        prev.next = next ; 
        next.prev = prev ; 
        head.next = null ; 
        head.prev = null ;
    }

    public LRUCache(int capacity) {
        this.h =  new HashMap<>();
        this.cap = capacity;
        this.left = new ListNode(0,0) ;
        this.right = new ListNode(0,0);
        this.left.next=right;
        this.right.prev=left;
    }
    
    public int get(int key) {
        if(h.containsKey(key)) {
            ListNode curr = h.get(key);
            remove(curr);
            insert(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(h.containsKey(key)) {
            remove(h.get(key));
        }
        ListNode curr = new ListNode(key,value);
        h.put(key,curr);
        insert(curr);
        if(h.size()>cap) {
            ListNode rem = left.next;
            h.remove(rem.key);
            remove(rem);
        }
    }
}
