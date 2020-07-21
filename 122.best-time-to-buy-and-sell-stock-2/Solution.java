/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Say you have an array prices for which the ith element is the price of a
given stock on day i.

Design an algorithm to find the maximum profit. You may complete as
many transactions as you like (i.e., buy one and sell one share of the
stock multiple times).

Note: You may not engage in multiple transactions at the same time 
i.e., you must sell the stock before you buy again).
*/

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]) {
                profit += prices[i+1] - prices[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input = {
            {7, 1, 5, 3, 6, 4}, // 7
            {1, 2, 3, 4, 5}, // 4
            {7, 6, 4, 3, 1} // 0
        };

        for (int[] in : input) {
            System.out.println(sol.maxProfit(in));
        }
    }
}