/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.
*/

public class Solution {

    public int maxDepth(TreeNode root) {
        return dfsDepth(root, 0);
    }

    private int dfsDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        depth++;
        int leftDepth = dfsDepth(root.left, depth);
        int rightDepth = dfsDepth(root.right, depth);
        return Math.max(leftDepth, rightDepth);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int _val) { val = _val; }
        TreeNode(int _val, TreeNode _left, TreeNode _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) {
        
    }
}