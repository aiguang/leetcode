import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 Design a simplified version of Twitter where users can post tweets,
 follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

 postTweet(userId, tweetId): Compose a new tweet.
 getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 follow(followerId, followeeId): Follower follows a followee.
 unfollow(followerId, followeeId): Follower unfollows a followee.
 Example:

 Twitter twitter = new Twitter();

 // User 1 posts a new tweet (id = 5).
 twitter.postTweet(1, 5);

 // User 1's news feed should return a list with 1 tweet id -> [5].
 twitter.getNewsFeed(1);

 // User 1 follows user 2.
 twitter.follow(1, 2);

 // User 2 posts a new tweet (id = 6).
 twitter.postTweet(2, 6);

 // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 twitter.getNewsFeed(1);

 // User 1 unfollows user 2.
 twitter.unfollow(1, 2);

 // User 1's news feed should return a list with 1 tweet id -> [5],
 // since user 1 is no longer following user 2.
 twitter.getNewsFeed(1);
 */
public class problem355DesignTwitter {
  public static void main(String[] args){
    Twitter twitter = new Twitter();
    twitter.postTweet(1,5);
    twitter.getNewsFeed(1);
    twitter.follow(1,2);
    twitter.postTweet(2,6);
    twitter.getNewsFeed(1);
    twitter.unfollow(1,2);
    twitter.getNewsFeed(1);

//    [null,null,[5],null,null,[5],null,[5]]
//    [null,null,[5],null,null,[6,5],null,[5]]
  }

}
class Twitter {
  class Message{
    int userid;
    int Msgid;
    int time;
    public Message(int userid,int Msgid,int time){
      this.userid = userid;
      this.Msgid = Msgid;
      this.time = time;
    }

  }
  Map<Integer,HashSet<Integer>> map;
  List<Message> MsgQ;
  int timestamp;
  /** Initialize your data structure here. */
  public Twitter() {

    MsgQ = new ArrayList<Message>();
    map =new HashMap<Integer, HashSet<Integer>>();
    timestamp = 0;
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    //int time = new Date().getTime();
    Message msg = new Message(userId,tweetId,timestamp++);
    MsgQ.add(0,msg);
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    int count = 0;
    List<Integer> res = new ArrayList<Integer>();
    //Comparator<Message> comp = ((Message a,Message b)->(b.time- a.time));
    //Collections.sort(MsgQ,comp);
    int i=0;
    while(count < 10 && i< MsgQ.size()){
      Message Msg = MsgQ.get(i++);
      int userid = Msg.userid;
      if(userid == userId || map.containsKey(userId)&&map.get(userId).contains(userid)){
        res.add(Msg.Msgid);
        count++;
      }
    }
    return res;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    if(map.containsKey(followerId)){
      map.get(followerId).add(followeeId);
    }else{
      HashSet<Integer> set = new HashSet<Integer>();
      set.add(followeeId);
      map.put(followerId,set);
    }
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if(map.containsKey(followerId) && map.get(followerId).contains(followeeId)){
      map.get(followerId).remove(followeeId);
    }
  }
}

