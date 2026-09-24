class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> h = new HashMap<>();
        for(int i =0 ;i < nums.length ;i ++){
            if(h.containsKey(target-nums[i])) 
            return new int[] {h.get(target-nums[i]),i};
            h.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}

// O(n) -> O(nlogn) -> O(n2)