class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    int cycleStart = 0;
    public int[] findRedundantConnection(int[][] edges) {
        for(int i = 1; i <= edges.length; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(-1,1);

        for(int i =edges.length -1 ;i>=0 ;i--) {
            int a = edges[i][0];
            int b = edges[i][1];

            if(cycle.contains(a) && cycle.contains(b)) 
            return new int[] {a,b};
        }

        return new int[2];

    }

    public boolean dfs(int parent , int i ) {
        if(visited.contains(i)) {
            cycleStart=i;
            return true;
        }
        visited.add(i);
        for(int j : adj.get(i)) {
            if(j!=parent) {
                if(dfs(i,j)) {
                    if(cycleStart != 0) cycle.add(i);
                    if(cycleStart == i) cycleStart=0;
                    return true;
                }
            }
        }
        return false;
    }
}
