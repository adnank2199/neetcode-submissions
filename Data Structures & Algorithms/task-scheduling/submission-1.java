class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b,a)) ;
        int[] freqs = new int[26];
        for(char c : tasks) {
            freqs[c-'A']++;
        }

        for(int i : freqs) {
            if(i>0)
            heap.offer(i);
        }

        Queue<int[]> q = new ArrayDeque<>();
        int cycles=0;
        while(!heap.isEmpty() || !q.isEmpty()) {
            cycles++;
            if(!heap.isEmpty()) {
                int freq = heap.poll();
                freq--;
                if(freq>0) 
                q.offer(new int[] {freq,cycles+n});
            }

            if(!q.isEmpty() && q.peek()[1] <= cycles) 
            heap.offer(q.poll()[0]);
        }

        return cycles;

    }
}
