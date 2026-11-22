class Solution {
    int[] helper;
    Map<Integer,List<int[]>> adj;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        helper = new int[n];
        Arrays.fill(helper, Integer.MAX_VALUE);
        adj = new HashMap<>();

        for(int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());

        for(int[] i : flights) {
            adj.get(i[0]).add(new int[] {i[1], i[2]});
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {src, 0});

        helper[src] = 0;
        int level = 0;

        while(!q.isEmpty() && level <= k) {
            int size = q.size();

            for(int j = 0; j < size; j++) {
                int[] curr = q.poll();

                for(int[] i : adj.get(curr[0])) {
                    int cost = curr[1] + i[1];

                    if(cost>helper[i[0]])
                    continue;

                    q.offer(new int[] {i[0], cost});
                    helper[i[0]] = Math.min(helper[i[0]], cost);
                }
            }

            level++;
        }

        return helper[dst] == Integer.MAX_VALUE ? -1 : helper[dst];
    }
}