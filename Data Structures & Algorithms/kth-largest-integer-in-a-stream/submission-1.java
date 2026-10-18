class KthLargest {
    List<Integer> heap ;
    int counter ;
    public KthLargest(int k, int[] nums) {
        heap = new ArrayList<>();
        counter=k;
        heap.add(0);
        for(int i : nums)
        push(i);
    }
    
    public int add(int val) {
        return push(val);
    }

    public void pop() {
        if(heap.size()==1)
        return ;
        if(heap.size()==2)
        {heap.remove(1); return;}

heap.set(1, heap.get(heap.size() - 1));
heap.remove(heap.size() - 1);

        int i = 1; 
        while(2*i < heap.size()) {
            if(2*i+1 < heap.size() && heap.get(i) > heap.get(2*i+1) && heap.get(2*i) > heap.get(2*i+1)) {
                int temp = heap.get(2*i+1);
                heap.set(2*i+1, heap.get(i));
                heap.set(i,temp);
                i=2*i+1;
            }
            else if(heap.get(2*i) < heap.get(i)) {
                int temp = heap.get(2*i);
                heap.set(2*i, heap.get(i));
                heap.set(i,temp);
                i=2*i;
            }
            else {
                break;
            }
        }
    }

    public int push(int x) {
        heap.add(x);
        int i = heap.size() - 1;
        while(i > 1 && heap.get(i) < heap.get(i/2)) {
            int temp = heap.get(i);
            heap.set(i,heap.get(i/2));
            heap.set(i/2,temp);
            i=i/2;
        }
        if(heap.size()-1 > counter) {
            pop();
        }
        return heap.get(1);
    }


}
