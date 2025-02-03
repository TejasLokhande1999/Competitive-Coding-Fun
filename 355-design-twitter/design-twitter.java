class Twitter {

    int time;
    Map<Integer, Set<Integer>> following;
    Map<Integer,List<Pair>> map;
    public Twitter() {
        time = 0;
        map = new HashMap<>();
        following = new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        
        map.putIfAbsent(userId, new ArrayList<>());

        map.get(userId).add(new Pair(time,tweetId));
        time = time+1;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        list.add(userId);
        if(following.get(userId) != null)
            list.addAll(following.get(userId));
        List<Pair> p= new ArrayList<>();

        for(int i=0;i<list.size();i++){

            if(map.get(list.get(i))!=null){
                p.addAll(map.get(list.get(i)));
            }

        }
        Collections.sort(p, (a,b)->b.time-a.time);
    
        List<Integer> tweets = new ArrayList<>();
        if(p.size()<10)
        {
            for(int i=0;i<p.size();i++){
                tweets.add(p.get(i).tweetId);
            }

            return tweets;
        }

        for(int i=0;i<10;i++){
                tweets.add(p.get(i).tweetId);
            }

            return tweets;


    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = following.get(followerId);
        if(set!=null){
            set.remove(followeeId);
            following.put(followerId,set);
        }
        
    }
}

class Pair{

    int time;
    int tweetId;

    Pair(int time, int tweetId){
        this.time = time;
        this.tweetId = tweetId;
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */