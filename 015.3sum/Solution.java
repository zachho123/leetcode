/*
https://leetcode.com/problems/3sum/

Given an array nums of n integers, are there elements a, b, c in nums such
that a + b + c = 0? Find all unique triplets in the array which gives the
sum of zero.

Note:
The solution set must not contain duplicate triplets.
*/
import java.util.*;

public class Solution {

    public final int TARGET_SUM = 0;

    public List<List<Integer>> threeSum(int[] nums) {
        return first(nums);
    }

    private List<List<Integer>> first(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twoSumSets =
                twoSum(Arrays.copyOfRange(nums, 0, i), TARGET_SUM - nums[i]);

            for (List<Integer> twoSumSet : twoSumSets) {
                if (twoSumSet.get(0) != twoSumSet.get(1)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[twoSumSet.get(0)]);
                    temp.add(nums[twoSumSet.get(1)]);
                    output.add(temp);
                }
            }
        }

        return output;
    }

    public List<List<Integer>> twoSum(int[] nums, int sum) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(sum-nums[i])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(seen.get(sum-nums[i]));
                temp.add(i);
                output.add(temp);
            }
            seen.put(nums[i], i);
        }

        return output;
    }

    public void printOutput(List<List<Integer>> output) {
        System.out.print("Ac: ");
        for (List<Integer> l : output) {
            System.out.print(l + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input1 = {-1,0,1,2,-1,-4};
        System.out.println("input1:"+Arrays.toString(input1));
        System.out.println("Ex: [-1,0,1], [-1,-1,2]");
        sol.printOutput(sol.threeSum(input1));
    }
}
