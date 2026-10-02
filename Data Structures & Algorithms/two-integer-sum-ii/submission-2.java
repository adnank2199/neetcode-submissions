class Solution {
    public int[] twoSum(int[] n, int target) {
        int L = 0 ; 
        int R = n.length-1;
        while(L<R) {
            if(n[L]+n[R] > target) 
            R--;
            else if(n[L] + n[R] < target)
            L++;
            else 
            return new int[] {L+1,R+1};
        }
        return new int[] {-1};
    }
}