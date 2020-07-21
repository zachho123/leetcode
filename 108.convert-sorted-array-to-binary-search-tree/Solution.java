/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Given an array where elements are sorted in ascending order, convert it to
a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree
in which the depth of the two subtrees of every node never differ by more
than 1.
*/

import java.util.LinkedList;
import java.util.Arrays;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return null;
        }

        TreeNode root = helper(nums, 0, nums.length - 1);

        return root;
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int middle = (start + end) / 2;
        System.out.println("mid:"+middle);
        TreeNode newNode = new TreeNode(nums[middle]);
        newNode.left = helper(nums, start, middle - 1);
        newNode.right = helper(nums, middle + 1, end);

        return newNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int _val) {
            val = _val;
        }
        TreeNode(int _val, TreeNode _left, TreeNode _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input1 = {-10, -3, 0, 5, 9};
        sol.sortedArrayToBST(input1);
    }
}