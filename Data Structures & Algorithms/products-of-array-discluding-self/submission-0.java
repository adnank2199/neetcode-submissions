class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] p = new int[nums.length];
        int[] s = new int[nums.length];
        for(int i =0 ; i<nums.length ; i++) {
            if(i==0)
            p[i]=nums[i];
            else
            p[i]=p[i-1]*nums[i];
        }
        for(int i = nums.length-1 ; i >-1 ;i-- ){
            if(i==nums.length-1)
            s[i]=nums[i];
            else
            s[i]=s[i+1]*nums[i];
        }
        int[] ans = new int[nums.length];
        for(int i =0 ; i < nums.length ; i++) {
            if(i==0)
            ans[i]=s[i+1];
            else if(i==nums.length-1)
            ans[i]=p[i-1];
            else 
            ans[i]=p[i-1] * s[i+1];
        }
        return ans;
    }
}  
