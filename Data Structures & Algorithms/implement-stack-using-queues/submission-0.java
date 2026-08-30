class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int size=0;
    public MyStack() {
        this.q1= new LinkedList<>();
        this.q2= new LinkedList<>();
        this.size=0;
    }
    
    public void push(int x) {
        if(size==0) {
            q1.add(x);
        }
        else {
            if(q1.isEmpty())
            {
                q1.add(x);
                while(!q2.isEmpty()) {
                    int curr = q2.poll();
                    q1.add(curr);
                }
            }
            else {
                q2.add(x);
                while(!q1.isEmpty()) {
                    int curr = q1.poll();
                    q2.add(curr);
                }
            }
        }
        size++;
    }
    
    public int pop() {
        size--;
        if(q1.isEmpty()) {
            return q2.poll();
        }
        else {
            return q1.poll();
        }
    }
    
    public int top() {
        if(q1.isEmpty()) {
            return q2.peek();
        }
        else {
            return q1.peek();
        }
    }
    
    public boolean empty() {
        return size==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */