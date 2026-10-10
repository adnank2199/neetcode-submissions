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
    int size;
    int cap;
    Map<Integer,ListNode> h;
    ListNode right;
    ListNode left;

    public void insert(ListNode head) {
        h.put(head.key , head) ;
        head.prev=this.right.prev;
        this.right.prev.next = head ;
        head.next = right ;
        this.right.prev = head ;
    }

    public void remove(ListNode head) {
        head.prev.next = head.next ;
        head.next.prev = head.prev ;
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        h = new HashMap<>();
        this.right = new ListNode(0,0);
        this.left = new ListNode(0,0);
        this.right.prev = left;
        this.left.next = right;
    }
    
    public int get(int key) {
        if(h.containsKey(key)) {
            ListNode curr = h.get(key) ;
            ListNode oldPrev = curr.prev; 
            ListNode oldNext = curr.next ; 
            oldPrev.next = oldNext ; 
            oldNext.prev = oldPrev;

            ListNode newPrev = right.prev ; 
            ListNode newNext = right;


            newPrev.next = curr;
            curr.prev = newPrev ;
            curr.next = newNext ; 
            newNext.prev = curr;
            return curr.val;
        }
        return -1 ;
    }
    
    public void put(int key, int value) {
        if(h.containsKey(key))
        {remove(h.get(key)); h.remove(key);}
        if(h.size() == cap) 
        {h.remove(left.next.key);remove(left.next); }
        ListNode curr = new ListNode(key,value);
        h.put(key,curr);
        insert(curr);
    }
}
