class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[] start = points[0];
        for(int[] i : points) {
            int dist = Math.abs((start[0] - i[0])) + Math.abs((start[1] - i[1]));
            heap.offer(new int[] {dist , i[0] , i[1]});
        }
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(start));
        int totalCost = 0 ;
        while(!heap.isEmpty()) {
            int[] curr = heap.poll();
            if(visited.contains(Arrays.toString(new int[] {curr[1],curr[2]})))
            continue;
            visited.add(Arrays.toString(new int[] {curr[1],curr[2]}));
            totalCost += curr[0];
            for(int[] i : points) {
                if(visited.contains(Arrays.toString(new int[] {i[0],i[1]})))
                continue;
                int dist = Math.abs((curr[1] - i[0])) + Math.abs((curr[2] - i[1]));
                heap.offer(new int[] {dist , i[0] , i[1]});
            }
        }

        return totalCost;
    }
}
