/*
https://leetcode.com/problems/delete-node-in-a-linked-list/

Write a function to delete a node (except the tail) in a singly linked list,
given only access to that node.
*/

public class Solution {
    // Because we are only given a ref to the node to be deleted
    // and due to problem statement it's guranteed it won't be the tail
    // we can simply change the node to be deleted to the next node
    // and then get rid of the copied node.
    // People on leetcode thought this was a stupid question, bc why
    // would we not have access to the head of a linked list. The normal
    // way to delete from a linked list is to take the node before the one
    // to be deleted and change the next reference on that node to skip
    // the "to be deleted" node.
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}