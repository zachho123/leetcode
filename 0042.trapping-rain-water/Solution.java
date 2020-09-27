import java.util.Arrays;

/***
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 */
public class Solution {
    public int trap(int[] height) {
        // int water = 0;
        // int[] maxLeftArr = new int[height.length];
        // int[] maxRightArr = new int[height.length];
        // int maxLeft = 0;
        // int maxRight = 0;

        // // Construct maxLeftArr which has the max value seen to left of index
        // for (int i = 0; i < height.length; i++) {
        //     maxLeftArr[i] = maxLeft;
        //     maxLeft = Math.max(maxLeft, height[i]);
        // }

        // // Construct maxRightArr which has the max value seen to right of index
        // for (int i = height.length - 1; i >= 0; i--) {
        //     maxRightArr[i] = maxRight;
        //     maxRight = Math.max(maxRight, height[i]);
        // }

        // // Calc water contribution for each index
        // for (int i = 0; i < height.length - 1; i++) {
        //     int min = Math.min(maxLeftArr[i], maxRightArr[i]);
        //     int theHeight = height[i];
        //     int added = min - theHeight;

        //     if (added > 0) {
        //         water += Math.min(maxLeftArr[i], maxRightArr[i]) - height[i];
        //     }
        // }

        // return water;

        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] > leftMax) {
                leftMax = height[left];
            }
            if (height[right] > rightMax) {
                rightMax = height[right];
            }
            if (leftMax < rightMax) {
                water += Math.max(0, leftMax - height[left]);
                left++;
            } else {
                water += Math.max(0, rightMax - height[right]);
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(s.trap(input));
    }
}