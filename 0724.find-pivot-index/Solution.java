/*
https://leetcode.com/problems/find-pivot-index/

Given an array of integers nums, write a method that returns the "pivot"
index of this array.

We define the pivot index as the index where the sum of the numbers to the
left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot
indexes, you should return the left-most pivot index.
*/
import java.util.*;

public class Solution {

    public int pivotIndex(int[] nums) {
        // return first(nums);
        return second(nums);
    }

    private int first(int[] nums) {
        int[] rightSums = new int[nums.length];
        int pivotIndex = -1;

        if (nums.length < 3) {
            return -1;
        }

        // populate rightSums
        int rightSum = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            rightSum += nums[i];
            rightSums[i] = rightSum;
        }

        if (rightSums[1] == 0) {
            return 0;
        }

        // go through left
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if (pivotIndex == -1) {
                if (i < nums.length-2 && leftSum == rightSums[i+2]) {
                    pivotIndex = i+1;
                } else if (i == nums.length-2 && leftSum == 0) {
                    pivotIndex = nums.length-1;
                    break;
                }
            }

        }

        return pivotIndex;
    }

    private int second(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        // if leftsum = sum of nums left of pivot
        // and rightsum = sum of nums right of pivot
        // and definition of pivot is leftsum = rightsum
        // then it makes sense that leftsum * 2 = total - pivot
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 == total - nums[i]) return i;
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input1 = {1,7,3,6,5,6};
        System.out.println(sol.pivotIndex(input1)); // expect 3

        int[] input2 = {1,2,3};
        System.out.println(sol.pivotIndex(input2)); // expect -1

        int[] input3 = {-1,-1,-1,-1,-1,0};
        System.out.println(sol.pivotIndex(input3)); // expect 2

        int[] input4 = {-1,-1,-1,0,1,1};
        System.out.println(sol.pivotIndex(input4)); // expect 0

        int[] input5 = {-1,-1,0,0,-1,-1};
        System.out.println(sol.pivotIndex(input5)); // expect 2

        int[] input6 = {-1,-1,0,1,1,0};
        System.out.println(sol.pivotIndex(input6)); // expect 5
    }
}
