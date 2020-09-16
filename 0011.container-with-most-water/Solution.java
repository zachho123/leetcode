/*
https://leetcode.com/problems/container-with-most-water/

Given n non-negative integers a1, a2, ..., an , where each represents a point
at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:
Input: [1, 8, 6, 2, 5, 4, 8, 3, 7]
Output: 49
*/

public class Solution {

    public int maxArea(int[] height) {
        //return bruteForce(height);
        return twoPointer(height);
    }

    public int bruteForce(int[] heights) {
        int maxVol = 0;

        for (int i = 0; i < heights.length-1; i++) {
            for (int j = i+1; j < heights.length; j++) {
                maxVol = Math.max(maxVol, Math.min(heights[i], heights[j]) * (j - i));
            }
        }

        return maxVol;
    }

    public int twoPointer(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxVol = 0;

        while (left != right) {
            maxVol = Math.max(maxVol, Math.min(heights[left], heights[right]) * (right-left));

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxVol;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println(sol.maxArea(input1));
    }
}
