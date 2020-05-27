/*
[355]设计推特
design-twitter
//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 堆 设计 哈希表

*/
package com.origin.algorithm.leetcode.editor.cn;

import java.util.*;

public class P355DesignTwitter {
    public static void main(String[] args) {
        //Solution solution = new P355DesignTwitter().new Solution();
    }

    /**
     * 思路：
     * 首先，需要保存关注状态，采用hash+set结构，每个set保存关注的用户
     * 其次，需要获取最近的10条推文，推文必须是自己发的，或者是关注的用户的
     * 因此推文需要保存推文id，发布用户
     *
     * 将当前所有推文构成链表，每次获取的时候从链表末尾开始获取自己或关注人的推文
     * 题目要求获取最近10条，也就是每个用户至多只需要保存10条即可
     * 所以全部保存会造成空间浪费
     * 因此不能全部保存，而是按用户纬度保存
     * 根据关注用户获取所有用户对应的推文，按时间归并取前10条
     * TODO 多路归并的解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Twitter {

        /**
         * 关注的信息
         * key为用户id，value为关注这个用户的所有用户id
         */
    private Map<Integer, Set<Integer>> subscribe = new HashMap<>();

    private Tweet tail = null;

    class Tweet {
        int userId;
        int tweetId;
        Tweet pre;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {

    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (tail == null) {
            tail = new Tweet(userId, tweetId);
        } else {
            Tweet tweet = new Tweet(userId, tweetId);
            tweet.pre = tail;
            tail = tweet;
        }

    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new LinkedList<>();
        Tweet tail = this.tail;
        while (list.size() < 10 && tail != null) {
            if (tail.userId == userId) {
                list.add(tail.tweetId);
                tail = tail.pre;
                continue;
            }
            //获取发布这条推文的作者的关注用户
            Set<Integer> set = subscribe.get(tail.userId);
            if (set != null && set.contains(userId)) {
                list.add(tail.tweetId);
            }
            tail = tail.pre;
        }
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = subscribe.computeIfAbsent(followeeId, k -> new HashSet<>());
        set.add(followerId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = subscribe.computeIfAbsent(followeeId, k -> new HashSet<>());
        set.remove(followerId);
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
//leetcode submit region end(Prohibit modification and deletion)

}