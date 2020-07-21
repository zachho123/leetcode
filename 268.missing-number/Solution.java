/*
https://leetcode.com/problems/missing-number/

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
find the one that is missing from the array.

Note:
Your algorithm should run in linear runtime complexity. Could you implement
it using only constant extra space complexity?
*/

import java.util.*;

public class Solution {

    // My solution first sorted the list, then iterated through to 
    // find the missing number.
    // @TC: O(nlgn)
    // @SC: O(1)
    public int missingNumber(int[] nums) {
        int i;

        // sort array
        Arrays.sort(nums);
        // iterate through
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return i;
    }

    // For this solution we use the fact XOR is its own inverse
    // (ie: A XOR A = 0)
    // @TC : O(n)
    // @SC : O(1)
    public int bit_manipulation(int[] nums) {
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }

        return missing;
    }

    // This solution utilizes Gauss' formula to compute the sum
    // of the first n natural numbers in constant time.
    // ie: SUM{i=0, n}[i] === n(n+1) / 2
    // Number that is missing is gauss - sum of nums
    public int gauss(int[] nums) {
        int n = nums.length;
        int gauss = n * (n + 1) / 2;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return gauss - sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input = {
            {1, 2, 3}, // 0 
            {0, 5, 2, 1, 3, 4, 7} // 6
        };

        for (int[] in : input) {
            System.out.println(sol.missingNumber(in));
        }
    }
}