class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,int[]> h = new LinkedHashMap<>();

        for(int i = 0;i<s.length();i++) {
            if(!h.containsKey(s.charAt(i))) {
                h.put(s.charAt(i) , new int[] {i,i});
            }
            else {
                h.get(s.charAt(i))[1] = i;
            }
        }

        List<int[]> ans1 = new ArrayList<>();

        for(Map.Entry<Character,int[]> e : h.entrySet()) {
            if(ans1.isEmpty()) 
            ans1.add(e.getValue());
            else {
                int[] last = ans1.get(ans1.size()-1);
                int[] curr = e.getValue();
                if(last[1] < curr[0])
                ans1.add(curr);
                else {
                last[0] = Math.min(last[0],curr[0]);
                last[1] = Math.max(last[1],curr[1]);}
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int[] i : ans1) {
            ans.add(i[1]-i[0]+1);
        }

        return ans;
    }
}
