/*
https://leetcode.com/problems/linked-list-cycle/

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which
represents the position (0-indexed) in the linked list where tail connects to.
If pos is -1, then there is no cycle in the linked list.

Followup: Can you solve using O(1) space?
*/

public class Solution {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        
        while (head != null && head.next != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        
        return false;
    }

    // constant space
    // public boolean hasCycle(ListNode head) {
    //     ListNode walk = head;
    //     ListNode run = head;
        
    //     while (run != null && run.next != null && run.next.next != null) {
    //         walk = walk.next;
    //         run = run.next.next;
            
    //         if (walk == run) {
    //             return true;
    //         }
    //     }
        
    //     return false;
    // }
}