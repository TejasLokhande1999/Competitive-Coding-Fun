class Twitter {

    Map<Integer, Set<Integer>> following;
    Map<Integer, List<Pair>> map;
    int timer;
    public Twitter() {
        following = new HashMap<>();
        map = new HashMap<>();
        timer=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        map.putIfAbsent(userId, new ArrayList<Pair>());
        map.get(userId).add(new Pair(tweetId,timer));
        timer+=1;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> userIds = new ArrayList<>();
        userIds.add(userId);
        if(following.get(userId) != null)
            userIds.addAll(following.get(userId));

        List<Pair> tweetIds = new ArrayList<>();
        for(int i=0;i<userIds.size();i++){
            if(map.get(userIds.get(i))!=null)
                tweetIds.addAll(map.get(userIds.get(i)));
        }

        Collections.sort(tweetIds, new PairComparator());

        List<Integer> retList = new ArrayList<>();
        for(int i=0;i<tweetIds.size();i++){
            Pair p = tweetIds.get(i);
            retList.add(p.tweetId);
            if(i==9){
                return retList;
            }
        }

        return retList;
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<Integer>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> removeL = following.get(followerId);
        if(removeL!=null)
            removeL.remove(followeeId);
        following.put(followerId,removeL);
    }
}

class Pair{

    int tweetId;
    int time;

    Pair(int tweetId, int time){
        this.tweetId = tweetId;
        this.time = time;
    }

}

class PairComparator implements Comparator<Pair>{

    public int compare(Pair p1, Pair p2){
        //sort in descending
        if(p1.time>p2.time){
            return -1;
        }else if(p1.time<p2.time){
            return 1;
        }else{
            return 0;
        }
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