class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones) {
            heap.offer(i);
        }

        while(heap.size()>1) {
            int a = heap.poll();
            int b = heap.poll();
            int rem;
            if(a>b) {
                rem = a-b;
            }
            else if(a<b) {
                rem = b-a;
            }
            else {
                rem = 0;
            }
            if(rem==0) 
            continue;
            heap.offer(rem);
        }
        return (heap.size()==0) ? 0 : heap.poll();
    }
}
