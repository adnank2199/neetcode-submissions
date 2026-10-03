public class Solution {
    public int trap(int[] h) {

        int LM = h[0];
        int RM = h[h.length-1];
        int L = 1 ;
        int R = h.length-2;
        int area = 0 ;
        while(L<=R) {
            if(LM<=RM) {
                if(LM-h[L] > 0)
                area+=LM-h[L];
                LM = Math.max(LM,h[L]);
                L++;
            }
            else {
                if(RM-h[R] > 0)
                area+=RM-h[R];
                RM = Math.max(RM,h[R]);
                R--;
            }
        }
        return area;
    }
}