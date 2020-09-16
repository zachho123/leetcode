/*
https://leetcode.com/problems/climbing-stairs/

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct
ways can you climb to the top?

Note: Given n will be a positive integer.
*/

public class Solution {
    
    // This solution uses a dynamic programming approach. It is based on the
    // idea that one can reach the ith step is two ways:
    // 1. Taking a single step from (i - 1)th step
    // 2. Taking two steps from (i - 2)th step.
    // Therefore, the total number of ways to reach the ith step is equal to
    // the sum of ways of reaching the (i - 1)th and (i - 2)th step.
    // If dp[i] denotes the number of ways to reach the ith step:
    // dp[i] = dp[i - 1] + dp[i - 2]
    public int climbStairs_dp(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input = {1, 2, 3};

        for (int in : input) {
            System.out.println(sol.climbStairs(in));
        }
    }
}