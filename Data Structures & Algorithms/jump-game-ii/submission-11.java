class Solution {
    public int jump(int[] nums) {
        Queue<Integer> q = new ArrayDeque<>();
        int index = 0;
        q.offer(0);
        int jump = 0 ;
        Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i =0;i<size;i++){
                int curr = q.poll();
                if(curr==nums.length-1)
                return jump;

                for(int j =1;j<=nums[curr];j++) {
                    if(visited.contains(curr+j))
                    continue;
                    q.offer(curr+j);
                    visited.add(curr+j);

                }
            }   
            jump++;
        }
        return jump;
    }

}
