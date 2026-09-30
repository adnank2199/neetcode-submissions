class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<int[]> s = new Stack<>();
        int maxA = 0;
        for(int i =0 ; i<h.length;i++) {
            int right = i;
            while(!s.isEmpty() && s.peek()[1] > h[i]) {
                int[] curr = s.pop();
                int area = curr[1] * (i-curr[0]);
                maxA = Math.max(maxA , area);
                right=curr[0];
            }
            s.push(new int[] {right,h[i]});
        }

        while(!s.isEmpty()) {
            int[] curr = s.pop();
            int area = curr[1] * (h.length-curr[0]);
            maxA= Math.max(maxA,area);
        }
        return maxA;
    }
}