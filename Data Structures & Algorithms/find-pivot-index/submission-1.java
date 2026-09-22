class Solution {
    public int pivotIndex(int[] nums) {
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        pref[0]=nums[0];
        suff[nums.length-1]=nums[nums.length-1];
        for(int i =1 , j=nums.length-2 ; i<nums.length ; i++,j--) {
            pref[i]=pref[i-1]+nums[i];
            suff[j]=suff[j+1]+nums[j];
        }
        for(int i=0 ; i <nums.length ; i++) {
            if(pref[i]==suff[i])
            return i;
        }
        return -1;
    }
}