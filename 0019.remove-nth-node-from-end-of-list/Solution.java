public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode toRemove = head;
        ListNode runner = head;

        // position runner n nodes ahead
        for (int i = 0; i < n; i++) {
            runner = runner.next;
        }

        // shift everything 1 node until runner hits null
        while (runner != null) {
            prev = toRemove;
            toRemove = toRemove.next;
            runner = runner.next;
        }

        // if new head is null, take next non null node or reutrn null
        if (prev == null) {
            if (toRemove.next != null) {
                return toRemove.next;
            } else {
                return null;
            }
        } else {
            prev.next = toRemove.next;
        }

        return head;
    }

    private ListNode makeLL(int[] vals) {
        ListNode head = null;

        for (int i = vals.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(vals[i], head);
            head = node;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] inputLists = {
            {1, 2, 3, 4, 5},
            {1},
            {1, 2},
            {1, 2, 3, 4, 5}
        };

        int[] inputN = {2, 1, 1, 5};

        for (int i = 0; i < inputLists.length; i++) {
            ListNode n = s.removeNthFromEnd(s.makeLL(inputLists[i]), inputN[i]);
            if (n == null) {
                System.out.println("null");
            } else {
                while (n != null) {
                    System.out.print(n.val + " ");
                    n = n.next;
                }
                System.out.print("\n");
            }
        }
    }
}

class ListNode {
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