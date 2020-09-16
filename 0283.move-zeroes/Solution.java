/*
https://leetcode.com/problems/move-zeroes/

Given an array nums, write a function to move all 0's to the end of it while
maintaining the relative order of the non-zero elements.

Notes:
1. You must do this in-place without making a copy of the array.
2. Minimize the total number of operations.
*/

public class Solution {

    public void moveZeroes(int[] nums) {
        int curr = 0;
        int front = curr+1;

        while (front < nums.length) {
            if (nums[curr] == 0) {
                if (nums[front] != 0) {
                    nums[curr] = nums[front];
                    nums[front] = 0;
                    curr++;
                    front++;
                } else {
                    front++;
                }
            } else {
                curr++;
                front++;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input1 = {0, 1, 0, 3, 12};
        sol.moveZeroes(input1);
        for (int i : input1) {
            System.out.println(i);
        }
    }
}