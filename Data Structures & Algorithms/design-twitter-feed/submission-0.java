class Twitter {
    private int timestamp;
    HashMap<Integer, List<int[]>> user;
    HashMap<Integer, List<Integer>> friends;

    public Twitter() {
        timestamp = 0;
        user = new HashMap<>();
        friends = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!user.containsKey(userId)) {
            user.put(userId, new ArrayList<>());
        }
        user.get(userId).add(new int[]{tweetId, ++timestamp});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        if (user.containsKey(userId)) {
            heap.addAll(user.get(userId));
        }

        if (friends.containsKey(userId)) {
            for (int i : friends.get(userId)) {
                if (user.containsKey(i)) {
                    heap.addAll(user.get(i));
                }
            }
        }

        List<Integer> feed = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (heap.isEmpty())
                break;

            feed.add(heap.poll()[0]);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;

        if (!friends.containsKey(followerId)) {
            friends.put(followerId, new ArrayList<>());
        }

        if (!friends.get(followerId).contains(followeeId)) {
            friends.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (friends.containsKey(followerId)) {
            friends.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}