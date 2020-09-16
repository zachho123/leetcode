/*
https://leetcode.com/problems/contains-duplicate/

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in
the array, and it should return false if every element is distinct.
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input = {
            {1, 2, 3, 1}, // true
            {1, 2, 3, 4}, // false
            {1, 1, 1, 3, 3, 4, 3, 2, 4, 2} // true
        };

        for (int[] in : input) {
            System.out.println(sol.containsDuplicate(in));
        }   
    }
}