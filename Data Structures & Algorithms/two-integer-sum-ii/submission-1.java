class Solution {
    public int[] twoSum(int[] n, int target) {
        int i=0, j =n.length-1;
        while(j>i) {
            if(n[i]+n[j]==target)
            break;
            if(n[i]+n[j] > target)
            j--;
            else 
            i++;

        }
        return new int[] {i + 1, j + 1};
    }
}