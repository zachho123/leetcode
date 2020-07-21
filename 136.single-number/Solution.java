/*
https://leetcode.com/problems/single-number/

Given a non-empty array of integers, every element appears twice except for
one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement
it without using extra memory?
*/

public class Solution {

    // The elegant solution uses bitwise manipulation. Here we use the XOR
    // operator which returns 1 when a single input is 1. In other words,
    // since we start with 0, numbers that appears twice will "turn on",
    // and then "turn off" their respective bits, while the number that only
    // appears once will only turn on its respective bits, leaving us with the
    // solo number after XOR'ing all the input numbers.
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int i : nums) {
            res ^= i; // this is the XOR operator in Java
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input1 = { 2, 2, 1 };
        int[] input2 = { 4, 1, 2, 1, 2 };

        System.out.println(sol.singleNumber(input1));
        System.out.println(sol.singleNumber(input2));
    }
}