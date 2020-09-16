/*
https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the continguous subarray (containing at least
one number) which has the largest sum and return its sum.

Follow up:
If you have figured out the O(n) solution, try coding another solution using
the divide and conquer approach, which is more subtle.
*/
public class Solution {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        // If adding the next num results in bigger sum, add.
        // Otherwise if the next num is greater than sum from last step,
        // just take the next num by itself (reset curr sum/contiguous streak).
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input = {
            {1, 2, 3}, // 6
            {-1, -2, -3}, // -1
            {1, -4, 3}, // 3
            {-2, 1, -3, 4, -1, 2, 1, -5, 4} // 6
        };

        for (int[] in : input) {
            System.out.println(sol.maxSubArray(in));
        }
    }   
}