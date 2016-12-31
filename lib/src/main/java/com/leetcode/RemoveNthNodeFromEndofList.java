package com.leetcode;

import java.util.HashMap;

/**
 * Created by hydra on 2016/12/31.
 */

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode node = fakeHead;
        int i = 0;
        while (node != null) {
            map.put(i, node);
            node = node.next;
            ++i;
        }

        int removeIndex = i - n;
        ListNode removeNode = map.get(removeIndex);
        ListNode preNodex = map.get(removeIndex - 1);
        if (preNodex != null) {
            preNodex.next = removeNode.next;
        }

        return fakeHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
