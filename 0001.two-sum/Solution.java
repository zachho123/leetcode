/*
https://leetcode.com/problems/two-sum/

Given an array of integers, return indices of the two numbers such that they
add up to a specific target.

You may assume that each input would have exactly one solution, and you may
not use the same element twice.
*/
import java.util.*;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        return first(nums, target);
    }

    private int[] first(int[] nums, int target) {
        int[] output = new int[2];
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(target-nums[i])) {
                output[0] = seen.get(target-nums[i]);
                output[1] = i;
                break;
            }
            seen.put(nums[i], i);
        }

        return output;
    }

    public static void main(String[] args) {

    }
}
