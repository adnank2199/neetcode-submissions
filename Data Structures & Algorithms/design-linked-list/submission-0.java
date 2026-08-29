class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {

    private ListNode head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);

        node.next = head;
        head = node;

        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);

        if (head == null) {
            head = node;
            size++;
            return;
        }

        ListNode curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        ListNode curr = head;

        // Stop at the node BEFORE index
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        ListNode node = new ListNode(val);

        node.next = curr.next;
        curr.next = node;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        ListNode curr = head;

        // Stop at the node BEFORE index
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        size--;
    }
}