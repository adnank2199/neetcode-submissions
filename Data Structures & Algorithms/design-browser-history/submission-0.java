class ListNode {
    String url;
    ListNode prev ,next;
    ListNode(String url) {
        this.url=url;
        this.next=null;
        this.prev=null;
    }
}

class BrowserHistory {
    ListNode curr;
    int size;
    public BrowserHistory(String homepage) {
        this.curr=new ListNode(homepage);
        size=1;
    }
    
    public void visit(String url) {
        ListNode node = new ListNode(url);
        node.prev=curr;
        curr.next = node;
        node.next=null;
        curr=node;
    }
    
    public String back(int steps) {
        while(steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}