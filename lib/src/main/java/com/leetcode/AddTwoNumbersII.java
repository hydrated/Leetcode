package com.leetcode;

/**
 * Created by hydra on 2016/11/16.
 */

public class AddTwoNumbersII {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList lastl1 = new LinkedList(-1);
        LinkedList lastl2 = new LinkedList(-1);


        ListNode currentNode = l1;
        while (currentNode != null) {
            LinkedList linkedList = new LinkedList(currentNode.val);
            linkedList.next = lastl1;
            lastl1.prev = linkedList;
            lastl1 = linkedList;
            currentNode = currentNode.next;
        }

        currentNode = l2;
        while (currentNode != null) {
            LinkedList linkedList = new LinkedList(currentNode.val);
            linkedList.next = lastl2;
            lastl2.prev = linkedList;
            lastl2 = linkedList;
            currentNode = currentNode.next;
        }

        LinkedList headLinkedList = addTwoList(lastl1, lastl2);

        return generateListNodeByList(headLinkedList);

    }

    private ListNode generateListNodeByList(LinkedList list) {
        ListNode firstNode = new ListNode(list.val);
        ListNode pointNode = firstNode;
        LinkedList l = list.prev;
        while (l != null) {
            ListNode node = new ListNode(l.val);
            pointNode.next = node;
            pointNode = node;
            l = l.prev;
        }

        return firstNode;
    }

    private LinkedList addTwoList(LinkedList l1, LinkedList l2) {
        LinkedList c1 = l1;
        LinkedList c2 = l2;

        boolean carry = false;
        LinkedList list = null;

        while (c1.val != -1 && c2.val != -1) {
            LinkedList localList = new LinkedList((c1.val + c2.val + (carry ? 1 : 0)) % 10);
            carry = (c1.val + c2.val + (carry ? 1 : 0) > 9);
            localList.prev = list;
            if (list != null) {
                list.next = localList;
            }
            c1 = c1.next;
            c2 = c2.next;

            list = localList;
        }

        if(c1.val == -1) {
            LinkedList d2 = c2;
            while (d2.val != -1) {
                LinkedList localList = new LinkedList((d2.val + (carry ? 1 : 0)) % 10);
                carry = ((d2.val + (carry ? 1 : 0)) > 9);
                localList.prev = list;
                list.next = localList;
                list = localList;
                d2 = d2.next;
            }
        }
        if(c2.val == -1) {
            LinkedList d1 = c1;
            while (d1.val != -1) {
                LinkedList localList = new LinkedList((d1.val + (carry ? 1 : 0)) % 10);
                carry = ((d1.val + (carry ? 1 : 0)) > 9);
                localList.prev = list;
                list.next = localList;
                list = localList;
                d1 = d1.next;
            }
        }
        if(carry) {
            LinkedList locallist = new LinkedList(1);
            locallist.prev = list;
            list.next = locallist;
            list = locallist;
        }

        return list;

    }


    public class LinkedList {
        int val;
        LinkedList prev;
        LinkedList next;

        LinkedList(int x) {
            val = x;
        }
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
