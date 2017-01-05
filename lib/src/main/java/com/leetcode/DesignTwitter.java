package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by hydra on 2017/1/5.
 */

public class DesignTwitter {

    private HashMap<Integer, LinkedList<Tweet>> newsfeed = new HashMap<>();
    private HashMap<Integer, Set<Integer>> follower = new HashMap<>();

    private PriorityQueue<Tweet> queue = new PriorityQueue<>(10);

    public void Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        LinkedList<Tweet> list = newsfeed.get(userId);
        if (list == null) {
            list = new LinkedList<>();
            list.add(tweet);
            newsfeed.put(userId, list);
            follow(userId, userId);
        } else {
            list.add(tweet);
            if (list.size() > 10) list.removeFirst();
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        queue.clear();
        Set<Integer> set = follower.get(userId);
        if (set != null) {
            for (Integer user : set) {
                if(newsfeed.get(user) != null) queue.addAll(newsfeed.get(user));
            }
        }

        if (queue.size() == 0) {
            return Collections.emptyList();
        } else {
            int i = 0;
            List<Integer> returnList = new ArrayList<>();
            while (!queue.isEmpty() && i < 10) {
                ++i;
                returnList.add(queue.poll().id);
            }
            return returnList;
        }
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = follower.get(followerId);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(followeeId);
        follower.put(followerId, set);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        Set set = follower.get(followerId);
        if (set != null) {
            set.remove(followeeId);
            follower.put(followerId, set);
        }

    }

    private static class Tweet implements Comparable<Tweet> {

        private static int TIME_INDEX = 0;

        private final int id;
        private final int time;

        public Tweet(int id) {
            this.id = id;
            this.time = TIME_INDEX++;
        }

        public int compareTo(Tweet other) {
            return other.time - time;
        }

    }
}
