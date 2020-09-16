import java.util.*;
/*
https://leetcode.com/problems/symmetric-tree/

Given a binary tree, check whether it is a mirror of itself (ie,
symmetric around its center).

For example, this binary tree is symmetric [1, 2, 2, 3, 4, 4, 3]
    1
   /  \
  2    2
 / \  / \ 
3   4 4  3

But the following is not [1, 2, 2, null, 3, null, 3]
     1
   /   \
  2     2
 / \   /  \
    3      3

Follow up: Solve it both recursively and iteratively.
*/
public class Solution {
    
    // Recursive approach. A tree is symmetric if the left subtree
    // is a mirror reflection of the right subtree. Two trees are a mirror
    // reflection of each other if:
    // 1. Their two roots have the same value.
    // 2. The right subtree of each tree is a mirror reflection of the left
    // subtree of the other tree.
    // @TC: O(n)
    // @SC: O(n)
    public boolean isSymmetric_recursive(TreeNode root) {
       return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }

    // Iterative approach. Each two consecutive nodes in the queue should
    // be equal. The algorithm works similarly to BFS. Each time, two nodes are
    // extracted and their values compared. Then, the right and left children
    // of the two nodes are inserted in the queue in opposite order.
    // @TC: O(n)
    // @SC: O(n)
    public boolean isSymmetric_iterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }

        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}