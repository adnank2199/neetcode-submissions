class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.offer(num);
        if(right.size()==0 || (left.peek() > right.peek())) {
            right.offer(left.poll());
        }

        if(left.size()+1 < right.size()) {
            left.offer(right.poll());
        }

        if(right.size()+1 < left.size()) {
            right.offer(left.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() > right.size()) 
        return left.peek();
        else if(right.size() > left.size()) 
        return right.peek();
        else 
        return (left.peek()+right.peek())/2.0;
    }
}
