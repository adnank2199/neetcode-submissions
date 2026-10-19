class MinHeap {
    List<Integer> heap;
    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        int i = heap.size()-1;
        while(i>1 && heap.get(i) < heap.get(i/2)) {
            int tmp = heap.get(i);
            heap.set(i,heap.get(i/2));
            heap.set(i/2,tmp);
            i=i/2;
        }
    }

    public Integer pop() {
        if(heap.size()==1)
        return -1;
        if(heap.size()==2)
        return heap.remove(1);
        int val = heap.get(1);
        heap.set(1,heap.remove(heap.size()-1));

        int i = 1;

        while(2*i < heap.size()) {
            int smallest = 2*i ; 
            if(2*i+1 < heap.size() && heap.get(2*i) > heap.get(2*i+1)) 
            smallest = 2*i+1;
            if(heap.get(i) > heap.get(smallest)) {
                int temp = heap.get(smallest);
                heap.set(smallest,heap.get(i));
                heap.set(i,temp);
            }
            else 
            break;
            i=smallest;
        }
        return val;
    }

    public Integer top() {
        if(heap.size()==1)
        return -1;
        return heap.get(1);
    }

    public void heapify(List<Integer> nums) {
        heap = new ArrayList<>();
        heap.add(0);
        heap.addAll(nums);
        int curr = nums.size() / 2;
        while(curr>0) {
            int i=curr;
            while(2*i < heap.size()) {
            int smallest = 2*i ; 
            if(2*i+1 < heap.size() && heap.get(2*i) > heap.get(2*i+1)) 
            smallest = 2*i+1;
            if(heap.get(i) > heap.get(smallest)) {
                int temp = heap.get(smallest);
                heap.set(smallest,heap.get(i));
                heap.set(i,temp);
            }
            else 
            break;
            i=smallest;
        }
            curr-=1;                    
        }
    }
}
