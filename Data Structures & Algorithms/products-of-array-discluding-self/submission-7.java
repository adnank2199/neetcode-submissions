class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        int prefix = 1 ; 
        for(int i =0 ; i < nums.length ; i ++) {
            res[i]=prefix;
            prefix*=nums[i];
        }
        int postfix = 1 ; 
        for(int i = nums.length-1; i>=0 ; i--){
            res[i]*=postfix;
            postfix*=nums[i];
        }
        return res;
    }
}  

// [1 2 8 48]
// [48 48 24 6]

// [1*48 , 1*24 , 2*6 , 8*1]

// each index i we need the left side of the prefix and the right side as postfix 
