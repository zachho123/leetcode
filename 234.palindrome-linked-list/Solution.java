/*
https://leetcode.com/problems/palindrome-linked-list/

Given a singly linked list, determine if it is a palindrome.
*/

public class Solution {

    // We have a slow and fast pointer to determine where halfway point is.
    // For lists with an odd # of nodes, need to increment slow once more.
    // We then reverse the 2nd half of the LL, then compare to front half.
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode reversed = reverse(slow);
        ListNode regular = head;

        while (reversed != null) {
            if (reversed.val != regular.val) {
                return false;
            }
            reversed = reversed.next;
            regular = regular.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}