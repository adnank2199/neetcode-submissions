class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> Integer.compare(profits[b] , profits[a]));
        PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> Integer.compare(capital[a] , capital[b]));

        for(int i =0 ; i<capital.length ;i++) {
            min.offer(i);
        }


        while(k>0) {
            while(!min.isEmpty() && w >= capital[min.peek()]) {
                max.offer(min.poll());
            }
            if(max.isEmpty())
            break;
            int index = max.poll();
            w+=profits[index];
            k--;
        }
        return w;
        
    }
}