/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/

Given two arrays, write a function to compute their intersection.

Note:
- Each elemen tin the result should appear as many times as it shows in both
arrays
- The result can be in any order

Follow Up:
- What if the given array is already sorted? How would you optimize your
algorithm?
- What if nums1's size is small compared to num2's size? Which algorithm is
better?
- What if elements of nums2 are stored on disk, and the memory is limited such
that you cannot load all elements in the memory at once?
*/

import java.util.*;

public class Solution {

    // This solution uses a two pointer approach on two sorted arrays.
    // This two pointer array solution would perform better if the
    // input arrays were already sorted. Also will perofrm
    // better if one of the input arrays is significantly shorter
    // in length than the other.
    public int[] intersect(int[] nums1, int[] nums2) {
        int idx1 = 0;
        int idx2 = 0;
        List<Integer> intersect = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                intersect.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }

        int[] output = new int[intersect.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = intersect.get(i);
        }

        return output;
    }

    // This solution uses a hashmap which keeps track of seen numbers
    // and the number of occurrences.
    public int[] intersect_hashmap(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> intersect = new ArrayList<>();

        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int j : nums2) {
            if (map.getOrDefault(j, 0) != 0) {
                intersect.add(j);
                map.put(j, map.get(j) - 1);
            }
        }

        int[] output = new int[intersect.size()];
        for (int k = 0; k < output.length; k++) {
            output[k] = intersect.get(k);
        }

        return output;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] nums1 = {
            {1, 2, 3},
            {1, 2, 2, 4},
            {4, 7, 20}
        };

        int[][] nums2 = {
            {3},
            {3, 5, 2, 1, 2},
            {9, 8, 12}
        };

        for (int i = 0; i < nums1.length; i++) {
            int[] ans = sol.intersect_hashmap(nums1[i], nums2[i]);
            System.out.println();
            for (int num : ans) {
                System.out.print(num + " ");
            }
        }
    }
}