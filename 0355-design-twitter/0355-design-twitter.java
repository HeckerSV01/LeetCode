class Twitter {
class tweet{
    int id;
    int user;
    int time;
    public tweet(int id,int user,int time)
    {
        this.id=id;
        this.user=user;
        this.time=time;
    }
}
int time;
List<tweet> list;
HashMap<Integer,HashSet<Integer>> map;
    public Twitter() {
        time=0;
        list=new ArrayList<>();
        map=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        ++time;
        tweet t=new tweet(tweetId,userId,time);
        list.add(t);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>(map.getOrDefault(userId,new HashSet<>()));
        set.add(userId);
        for(int i=list.size()-1;i>=0&&res.size()<10;i--)
        {
            if(set.contains(list.get(i).user))
            {
                res.add(list.get(i).id);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        map.putIfAbsent(followerId,new HashSet<>());
        map.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId))
        {
            return;
        }
        map.get(followerId).remove(followeeId);
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