class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer,List<double[]>> adj = new HashMap<>();
        for(int i = 0; i<n ;i++) {
            adj.put(i,new ArrayList<>());
        }

        int j = 0;

        for(int[] i : edges) {
            adj.get(i[0]).add(new double[] {i[1] , succProb[j]});
            adj.get(i[1]).add(new double[] {i[0] , succProb[j]});
            j++;
        }

        PriorityQueue<double[]> heap = new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        heap.offer(new double[] {1.0,start_node});
        int[] visited = new int[n];
        Arrays.fill(visited,-1);

        while(!heap.isEmpty()) {
            double[] curr = heap.poll();
            double prob = curr[0];
            int source = (int) curr[1];

            if(source==end_node) 
            return prob;

            if(visited[source]!=-1)
            continue;
            visited[source] = 1;

            for(double[] i : adj.get(source)){
                int nextNode = (int) i[0];
                double edgeProb = i[1];

                if(visited[nextNode]!=-1)
                continue;

                heap.offer(new double[] {edgeProb*prob , nextNode});
            }
        }

        return 0;
        
    }
}