package com.leetcode;

import java.util.HashMap;

/**
 * Created by hydra on 2017/1/2.
 */

public class LFUCache {

    private HashMap<Integer, Node> cache = new HashMap<>();

    private Node head = null;
    private Node tail = null;

    private final int capacity ;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            moveNodeToHead(node);
            return node.value;
        }

        return -1;
    }

    public void set(int key, int value) {
        if (capacity == 0) return;

        Node node = cache.get(key) == null ? new Node(key, value) : cache.get(key);
        if(cache.size() == capacity) {
            removeTail(tail);
        }
        cache.put(key, node);
    }

    private void removeTail(Node node) {
        if(node.prev != null) {
            node.prev.next = null;
            tail = node.prev;
        }
        cache.remove(node.key);
    }

    private void moveNodeToHead(Node node) {
        if(head == null) {
            head = node;
            tail = node;
        } else {
            if(node.next != null) {
                node.next.prev = node.prev;
            }
            if(node.prev != null) {
                node.prev.next = node.next;
            }
            if(tail.prev == null) {
                tail.prev = node;
            }
            node.prev = null;
            node.next = head;
            head = node;
        }
    }


    private class Node {
        Node prev;
        Node next;
        int value;
        int key;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

}
