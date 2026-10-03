class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for(int i =0; i<nums.length;i++) {
            int target = -1 * nums[i];
            int L = i+1 ; 
            int R = nums.length-1;

            while(L<R) {
                if(nums[L] + nums[R] == target) 
                {ans.add(new ArrayList<>(List.of(nums[i],nums[L],nums[R]))); L++ ; R--;}
                else if(nums[L]+nums[R] > target) 
                R--;
                else 
                L++;
            }
        }
        return new ArrayList<>(ans);
    }
}