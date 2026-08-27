class Solution {
    public int maxArea(int[] h) {
        int i = 0 ;
        int j = h.length-1;
        int max = 0;
        while(i<j) {
            int area = Math.min(h[i],h[j]) * (j-i);
            max=Math.max(area,max);
            if(h[i]<h[j]) 
            i++;
            else
            j--;
        }
        return max;
    }
}