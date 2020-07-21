/*
https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative
integers. The digits are stored in reverse order and each of their nodes
contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except
the number 0 itself.

Example:
Input : (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output : (7 -> 0 -> 8)
Explanation: 342 + 465 = 807

public class ListNode {
    int val;
    ListNode next;
    ListNode (int x ) { val = x; }
}
*/

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode (int x ) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addWithCarry(l1, l2, false);
    }

    private ListNode addWithCarry(ListNode l1, ListNode l2, boolean c) {
        int val1 = isNotNull(l1) ? l1.val : 0;
        int val2 = isNotNull(l2) ? l2.val : 0;
        int sum = c ? val1+val2+1 : val1+val2;
        boolean carry = sum >= 10 ? true : false;
        ListNode output = new ListNode(sum%10);

        if (isNotNull(l1) && isNotNull(l1.next)) {
            if (isNotNull(l2) && isNotNull(l2.next)) {
                output.next = addWithCarry(l1.next, l2.next, carry);
            } else {
                output.next = addWithCarry(l1.next, null, carry);
            }
        } else if (isNotNull(l2) && isNotNull(l2.next)) {
            output.next = addWithCarry(null, l2.next, carry);
        } else {
            output.next = carry ? new ListNode(1) : null;
        }

        return output;
    }

    private boolean isNotNull(ListNode l) {
        return l != null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode l1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        l1.next = l1_2;
        ListNode l1_3 = new ListNode(3);
        l1_2.next = l1_3;

        ListNode l2 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        l2.next = l2_2;
        ListNode l2_3 = new ListNode(4);
        l2_2.next = l2_3;

        ListNode ans = sol.addTwoNumbers(l1, l2);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
}
