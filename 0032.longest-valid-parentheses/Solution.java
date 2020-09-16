/*
https://leetcode.com/problems/longest-valid-parentheses/

Given a string containing just the characters '(' and ')', find the length of 
the longest valid (well-formed) parentheses substring.
*/

import java.util.Stack;

public class Solution {

    public int longestValidParentheses(String s) {
        int longest = 0;
        int currCount = 0;
        Stack<Integer> stack = new Stack<>();

        if (s == null || s.length() < 2) {
            return 0;
        }

        // We initialize the stack with -1 to have a reference point
        // if the string starts with "()" (explained below when seeing ')')
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If we see a closing paren, pop off the top of the stack 
            // (this essentially marks the matching open paren as matched),
            // then calc the current valid len by subtracting the index of the 
            // last seen non-matched symbol (new top of stack) from the 
            // current index. If the initial popping of the stack results in an
            // empty stack (ie: no ref point), instead of calc'ing len, push
            // current index onto the stack.
            if (c == ')') {
                stack.pop();

                if (stack.size() == 0) {
                    stack.push(i);
                } else {
                    currCount = i - stack.peek();
                    if (currCount > longest) { longest = currCount; }
                }
            // If we see an open paren, push the current index onto the stack.
            } else {
                stack.push(i);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String in1 = "(()"; // 2
        String in2 = ")()())"; // 4
        String in3 = ")()(()"; // 2 
        String in4 = ")()(())"; // 6
        String in5 = "((())()"; // 6

        System.out.println(sol.longestValidParentheses(in1));
        System.out.println(sol.longestValidParentheses(in2));
        System.out.println(sol.longestValidParentheses(in3));
        System.out.println(sol.longestValidParentheses(in4));
        System.out.println(sol.longestValidParentheses(in5));
    }
}