class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0; i<nums.length;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -1 * nums[i];
            int L = i+1 ;
            int R = nums.length-1;

            while(L<R) {
                if(nums[L] + nums[R] == target) 
                {ans.add(new ArrayList<>(List.of(nums[i],nums[L],nums[R]))); 
                while(L<R && nums[L] == nums[L+1]) L++;
                while(L<R && nums[R] == nums[R-1]) R--;
                L++;
                R--;
                }
                else if(nums[L]+nums[R] > target) 
                R--;
                else 
                L++;
            }
        }
        return ans;
    }
}