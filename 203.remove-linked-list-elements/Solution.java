/*
https://leetcode.com/problems/remove-linked-list-elements/

Remove all elements from a linked list of integers that have value val.
*/

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1, head);
        ListNode prev = newHead;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = prev.next;
        }

        return newHead.next;
    }
}