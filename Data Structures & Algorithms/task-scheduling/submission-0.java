class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        int[] freqs = new int[26];

        for(char c : tasks) {
            freqs[c-'A']++;
        }

        for(int i : freqs) {
            if(i>0) 
            max.offer(i);
        }

        int cycles=0;

        Queue<int[]> q = new ArrayDeque<>();

        while(!max.isEmpty() || !q.isEmpty()) {
            cycles++;

            if(!max.isEmpty()) {
                int freq = max.poll();
                freq--;
                if(freq!=0)
                q.offer(new int[] {freq,cycles+n});
            }

            if(!q.isEmpty() && q.peek()[1] <= cycles) {
                int[] curr = q.poll();
                max.offer(curr[0]);
            }

        }
        return cycles;
    }
}
