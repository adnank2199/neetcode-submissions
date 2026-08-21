class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> a = new HashMap<>();
        for(int i =0; i < nums.length; i++ ) { 
            int diff = target-nums[i];
            if(a.containsKey(diff) && a.get(diff)!=i) {
                return new int[] {a.get(diff) , i};
            }
            else
            a.put(nums[i],i);
        }
        return new int[0];

    }
}
