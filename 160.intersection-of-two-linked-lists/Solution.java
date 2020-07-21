/*
https://leetcode.com/problems/intersection-of-two-linked-lists/

Write a program to find the node at which the intersection of two singly
linked lists begins.

Notes:
- If the two linked lists have no intersection at all, return null.
- The linked lists must retain their original structure after the function
returns.
- You may assume there are no cycles anywhere in the entire linked structure.
- Your code should preferably run in O(n) time and use only O(1) memory.
*/

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        if (a == null && b == null) {
            return null;
        }

        while (a !=  b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}