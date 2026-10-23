class Twitter {
    private int timestamp=0;
    HashMap<Integer,List<int[]>> user ;
    HashMap<Integer,HashSet<Integer>> friend;
    public Twitter() {
        user = new HashMap<>();
        friend = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        user.putIfAbsent(userId,new ArrayList<>());
        user.get(userId).add(new int[] {tweetId , timestamp++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(b[1],a[1]));
        if(user.containsKey(userId)) 
        heap.addAll(user.get(userId));

        if(friend.containsKey(userId)) {
            for(int i : friend.get(userId)) {
            if(user.containsKey(i))
            heap.addAll(user.get(i));
        }
        }



        if(heap.size()==0)
        return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        for(int i =0 ; i < 10 ; i++) {
            if(heap.size()==0)
            break;
            ans.add(heap.poll()[0]);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)
        return;
        friend.putIfAbsent(followerId,new HashSet<>());
        friend.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        friend.get(followerId).remove(Integer.valueOf(followeeId));
    }
}
