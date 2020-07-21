/*
https://leetcode.com/problems/reverse-linked-list/

Reverse a singly linked list.

A linked list can be reversed either iteratively or recursively.
Could you implement both?
*/

import java.util.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // recursive solution
    // public ListNode reverseList(ListNode head) {
    //     if (head == null || head.next == null) { return head; }
    //     ListNode n = reverseList(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return n;
    // }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}