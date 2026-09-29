class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> s = new Stack<>();
        int[] result = new int[temp.length];
        for(int i = 0 ; i < temp.length ; i++) {
            while(!s.isEmpty() && s.peek()[0] < temp[i]) {
                int[] curr = s.pop();
                result[curr[1]] = i-curr[1];
            }
           s.push(new int[] {temp[i],i});
            
        }
        while(!s.isEmpty()) {
            int[] curr = s.pop();
            result[curr[1]] = 0;
        }
        return result;
    }
}
