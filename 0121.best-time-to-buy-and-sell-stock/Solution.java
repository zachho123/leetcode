/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Say you have an array for which the ith element is the price of a given
stock on day i.

If you were only permitted to complete at most one transaction (i.e.,
buy one and sell one share of the stock), design an algorithm to find the
maximum profit.

Note that you cannot sell a stock before you buy one.
*/

public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public int maxProfit_singlePass(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input = {
            {1, 2, 3}, // 2
            {6, 2, 1}, // 0
            {2, 4, 6, 1, 2}, // 4
            {6, 4, 5, 1, 2} // 1
        };

        for (int[] in : input) {
            System.out.println(sol.maxProfit(in));
            System.out.println(sol.maxProfit_singlePass(in));
        }
    }
}