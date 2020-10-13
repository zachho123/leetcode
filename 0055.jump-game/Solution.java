/**
 * Given array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 */
import java.util.*;

public class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            if (maxReachable < currentIndex) {
                return false;
            }
            int nextStep = currentIndex + nums[currentIndex];
            maxReachable = Math.max(maxReachable, nextStep);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] tests = {
            {2, 3, 1, 1, 4}, // true
            {3, 2, 1, 0, 4}, // false
            {2, 3, 1, 2, 4}, // true
            {2, 0} // true
        };

        for (int[] in : tests) {
            System.out.println(s.canJump(in));
        }
    }
}