class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        TreeMap<Integer,Integer> s = new TreeMap<>();
        int L = 0, R = 0;
        int[] ans = new int[arr.length-k+1];
        int index=0;
        while(R<arr.length) {
            s.put(arr[R],s.getOrDefault(arr[R],0)+1);
            if(R-L+1 == k) {
                int curr = arr[L] ;
                ans[index] = s.lastKey();
                if(s.get(curr) >1)
                s.put(curr, s.get(curr)-1);
                else
                s.remove(curr);
                index++;
                L++;
            }
            R++;
        }
        return ans;
    }
}
