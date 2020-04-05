package com.kururu.skillup.algorithm.problems.kakao;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

/**
 * <h2>Add Two Numbers</h2>
 * <ol>
 *     <li>You are given two non-empty linked lists representing two non-negative integers.
 *     The digits are stored in reverse order and each of their nodes contain a single digit.
 *     Add the two numbers and return it as a linked list.</li>
 *     <li>You may assume the two numbers do not contain any leading zero,
 *     except the number 0 itself.</li>
 * </ol>
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Kakao3 implements AlgorithmIF {

    private int[] inputArray1 = null;
    private int[] inputArray2 = null;

    private ListNode[] inputListNode1 = new ListNode[3];
    private ListNode[] inputListNode2 = new ListNode[3];

    private final ListNode headPoint = new ListNode(0);


    public void input() {
        inputArray1 = new int[]{2, 4, 3};
        inputArray2 = new int[]{5, 6, 4};

        for (int i = 0; i < 3; i++) {
            inputListNode1[i] = new ListNode(inputArray1[i]);
            inputListNode2[i] = new ListNode(inputArray2[i]);
        }

        for (int i = 0; i < 3; i++) {
            if (i != 2) {
                inputListNode1[i].next = inputListNode1[i + 1];
                inputListNode2[i].next = inputListNode2[i + 1];
            } else {
                inputListNode1[i].next = headPoint;
                inputListNode2[i].next = headPoint;
            }

        }

    }

    public void process() {

        ListNode result = addTwoNumbers(inputListNode1[0], inputListNode2[0]);

    }

    public void output() {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    private class ListNode {

        public int val;

        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

}
