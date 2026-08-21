class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i : nums) {
            if(h.containsKey(i)) {
                h.put(i,h.get(i)+1);
            }
            else
            h.put(i,1);
        }
        int[] ans = new int[k];
        int curr=0;
        ArrayList<Map.Entry<Integer,Integer>> as = new ArrayList<>(h.entrySet());
        as.sort((a,b)->b.getValue() - a.getValue());
        for(int i=0;i<k;i++){
            ans[i] = as.get(i).getKey();
        }
        return  ans;
    }
}
