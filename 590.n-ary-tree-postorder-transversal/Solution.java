/*
https://leetcode.com/problems/n-ary-tree-postorder-traversal/

Given an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, 
each group of children is separated by the null value (See examples).

Follow up:
Recursive solution is trivial, could you do it iteratively?
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root != null) {
            postorderRecursive(root, res);
        }

        return res;
    }

    private void postorderRecursive(Node root, List<Integer> l) {
        if (root.children != null) {
            for (Node n : root.children) {
                postorderRecursive(n, l);
            }
        }
        l.add(root.val);
    }

    private Node createTree(Integer[] input) {
        Node root = new Node(input[0]);
        Node currNode = root;
        List<Node> currChildren = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();

        for (int i = 2; i < input.length; i++) {
            if (input[i] == null) {
                currNode.children = currChildren;
                currNode = queue.poll();
                currChildren = new ArrayList<>();
            } else {
                Node n = new Node(input[i]);
                currChildren.add(n);
                queue.add(n);
            }
        }
        currNode.children = currChildren;

        return root;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        Integer[] input1 = {1,null,3,2,4,null,5,6};
        //Output: [5,6,3,2,4,1]

        Integer[] input2 = {1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,
            null,11,null,12,null,13,null,null,14};
        //Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]

        Node root1 = sol.createTree(input1);
        //Node root2 = sol.createTree(input2);

        List<Integer> sol1 = sol.postorder(root1);
        for (Integer i : sol1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}