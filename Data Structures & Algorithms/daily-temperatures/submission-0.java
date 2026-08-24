class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int []> s = new Stack<> ();
        int[] ans = new int[temp.length];
        for(int i = 0 ; i< temp.length ; i++) {
            if(s.isEmpty()) {
                s.push(new int[] {temp[i],i});
            }
            else{
                while(!s.isEmpty() && s.peek()[0] < temp[i]){
                    int[] a = s.pop();
                    ans[a[1]]=i-a[1];
                }
                s.push(new int[] {temp[i],i});
            }
        }
        while(!s.isEmpty()){
            int[] a = s.pop();
            ans[a[1]]=0;
        }
        return ans;
    }
}
