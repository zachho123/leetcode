import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode curr = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            new Comparator<ListNode>() {
                public int compare(ListNode l1, ListNode l2) {
                    return l1.val - l2.val;
                }
            }
        );

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;

            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        curr.next = null;

        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mergeKLists(new ListNode[] {null}));
    }
}