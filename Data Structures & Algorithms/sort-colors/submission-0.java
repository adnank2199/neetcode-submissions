class Solution {
    public void sortColors(int[] nums) {
        int[] bs = new int[3];
        for(int i : nums) {
            bs[i]++;
        }
        int curr = 0;
        for(int i =0 ;i<3;i++){
            int counter = 0 ;
            while(counter<bs[i]) {
                nums[curr++] = i;
                counter++;
            }
        }
    }
}