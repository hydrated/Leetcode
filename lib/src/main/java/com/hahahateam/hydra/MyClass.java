package com.hahahateam.hydra;

import com.leetcode.AddTwoNumbersII;
import  com.leetcode.AddTwoNumbersII.ListNode;

public class MyClass {

    public static void main(String args[]) {

        int[] a = {7,2,4,3};
        int[] b = {5,6,4};

        ListNode firstNode1 = new ListNode(8);
        firstNode1.next = new ListNode(9);
        firstNode1.next.next = new ListNode(9);


        ListNode secondNode1 = new ListNode(2);
//        secondNode1.next = new ListNode(6);
//        secondNode1.next.next = new ListNode(4);

        AddTwoNumbersII atn2 = new AddTwoNumbersII();
        ListNode node = atn2.addTwoNumbers(firstNode1, secondNode1);

        System.out.print("over");


    }

}
