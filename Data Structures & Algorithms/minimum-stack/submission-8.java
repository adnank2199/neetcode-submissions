class MinStack {
    private Stack<Long> stack ;
    long min;
    public MinStack() {
        stack = new Stack<> ();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
        {
            stack.push(0L);
            min=val;
        }
        else
        {
            stack.push((long)val-min);
            if(min > val)
            min = val;
        }
    }
    
    public void pop() {
        long top = stack.pop();
        if(top > 0)
        return;
        min = min - top;
    }
    
    public int top() {
        long top = stack.peek();
        if (top > 0) return (int)(top + min);
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}