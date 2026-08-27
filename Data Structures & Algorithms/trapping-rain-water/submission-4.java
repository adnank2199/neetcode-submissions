public class Solution {
    public int trap(int[] h) {

        int l=0 , r = h.length-1;
        int lm =h[l] , rm =h[r];
        int area=0;
        while(l<r) {
            if(lm <= rm) {
                l++;
                if(lm-h[l] <0);
                else
                area+=lm-h[l];
                lm = Math.max(lm , h[l]);
            }
            else {
                r--;
                if(rm-h[r] <0);
                else
                area+=rm-h[r];
                 rm = Math.max(rm , h[r]);
            }
            
        }
        return area;
    }
}