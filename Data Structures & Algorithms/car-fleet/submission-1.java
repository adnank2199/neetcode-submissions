class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for(int i=0;i<position.length;i++) {
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
        }
        Arrays.sort(pair, (a,b) -> Integer.compare(b[0],a[0]));
        Stack<Double> s = new Stack<>();
        for(int [] i : pair) {
            double curr = (double) (target -i[0])/i[1];
            if(s.isEmpty() || curr > s.peek()) {
                s.push(curr);
            }
        }
        return s.size();
    }
}
