class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap<>() ; 
        for(int i : nums) {
            h.put(i,h.getOrDefault(i,0)+1);
        }

        int[] ans = new int[k];
        ArrayList<Map.Entry<Integer,Integer>> curr = new ArrayList<>(h.entrySet());
        curr.sort((a,b)-> b.getValue()-a.getValue());

        for(int i =0 ; i<k ;i++) {
            ans[i] = curr.get(i).getKey();
        }
        return ans;
    }
}
