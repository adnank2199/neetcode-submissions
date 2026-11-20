class Solution {
    List<String> ans = new ArrayList<>();
    Map<String , PriorityQueue<String>> adj;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for(List<String> i : tickets) {
            adj.putIfAbsent(i.get(0) , new PriorityQueue<>());
            adj.putIfAbsent(i.get(1) , new PriorityQueue<>());

            adj.get(i.get(0)).offer(i.get(1));
        }

        topo("JFK");

        Collections.reverse(ans);

        return ans;
        
    }

    public void topo(String curr) {
        while(!adj.get(curr).isEmpty()) {
            String s = adj.get(curr).poll();
            topo(s);
        }
        ans.add(curr);
    }

}
