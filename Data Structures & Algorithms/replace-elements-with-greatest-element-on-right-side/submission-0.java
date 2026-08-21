class Solution {
    public int[] replaceElements(int[] arr) {
        int a = arr.length-1;
        int curr=-1;
        while(a > -1) {
            int b = arr[a];
            arr[a] = curr ; 
            if(curr < b)
            curr=b;
            a--;
        }
        return arr;
    }
}