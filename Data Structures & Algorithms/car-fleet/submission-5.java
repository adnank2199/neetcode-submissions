class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] num= new int[speed.length][];
        for(int i = 0 ; i < speed.length ; i ++ ) {
            num[i] = new int[] {position[i],speed[i]};
        }
        Arrays.sort(num , (a,b) -> Integer.compare(b[0],a[0]));
        Stack<Double> s = new Stack<>() ;

        for(int i = 0; i<speed.length ; i++) {
            double time = (double) (target-num[i][0])/num[i][1];
            if(s.isEmpty() || s.peek() < time)
            s.push(time);
        }
        return s.size();

    }
}
