class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<int []> s = new Stack<>();
        int max = 0;
        for(int i=0; i< h.length;i++) {
            int start = i; 

            while(!s.isEmpty() && s.peek()[1]>h[i]) {
                int [] curr = s.pop();
                int area = curr[1] * (i-curr[0]);
                max = Math.max(area,max);
                start=curr[0];
            }
            s.push(new int[] {start , h[i]});
        }

        while(!s.isEmpty()) {
            int [] curr = s.pop();
            int area = curr[1] * (h.length - curr[0]);
            max = Math.max(area,max);
        }
        return max;
    }
}