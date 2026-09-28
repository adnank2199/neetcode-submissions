class MinStack {
    private Stack<Long> s;
    long min;
    public MinStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        if(s.isEmpty()) {
            s.push(0L);
            min = val ;
        }
        else {
            s.push(val-min);
            if(min > val)
            min = val;
        }
    }

    public void pop() {
        long curr = s.pop();
        if(curr >= 0)
        return;
        min = min - curr ;
    }

    public int top() {
        long top = s.peek();
        if(top>0) return (int)(min + top);
        return (int)(min);
    }

    public int getMin() {
        return (int)min;
    }
}