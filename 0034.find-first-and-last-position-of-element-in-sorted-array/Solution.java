import java.util.Arrays;

import java.util.*;

public class Solution {
    /**
     * Given an array of ints sorted in ascending order, find the starting
     * and ending position of a given target value. If target is not found in
     * the array, return [-1, -1].
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[] {-1, -1};
        if (nums.length == 0) {
            return pos;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int pivot = nums[mid];
            
            if (pivot < target) {
                start = mid + 1;
            } else if (pivot > target) {
                end = mid - 1;
            } else {
                // Instead of performing an expansion outwards, we should
                // alter our binary search to find the first / last instances.
                int left = mid;
                while (left >= 0 && nums[left] == target) {
                    pos[0] = left;
                    left--;
                }

                int right = mid;
                while (right < nums.length && nums[right] == target) {
                    pos[1] = right;
                    right++;
                }
                break;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        CustomInput[] inputs = {
            new CustomInput(new int[] {5, 7, 7, 8, 8, 10}, 8),
            new CustomInput(new int[] {5, 7, 7, 8, 8, 10}, 6),
            new CustomInput(new int[] {}, 0),
            new CustomInput(new int[] {1}, 1),
            new CustomInput(new int[] {2, 2}, 1),
            new CustomInput(new int[] {2, 2}, 2),
            new CustomInput(new int[] {1, 4}, 4),
            new CustomInput(new int[] {2, 2}, 3)
        };

        for (CustomInput in : inputs) {
            String inputArr = Arrays.toString(in.nums);
            String outputArr = Arrays.toString(s.searchRange(in.nums, in.target));
            System.out.println(inputArr + " " + in.target + " " + outputArr);
        }
    }
}

class CustomInput {
    int[] nums;
    int target;

    CustomInput(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }
}