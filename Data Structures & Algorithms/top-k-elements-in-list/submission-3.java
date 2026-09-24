class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap<>() ; 
        for(int i : nums) {
            h.put(i,h.getOrDefault(i,0)+1);
        }

        List<Integer>[] freq = new List[nums.length+1];

        for(int i =0 ; i <=nums.length ; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> m : h.entrySet()) {
            freq[m.getValue()].add(m.getKey());
        }

        int[] ans = new int[k];
        int index =0 ;
        for(int i = freq.length-1  ; i>-1 && index<k ;i--) {
            for(int n : freq[i]) {
                ans[index++] = n;
                if(index==k)
                return ans;
            }
        }
        return ans;
    }
}
