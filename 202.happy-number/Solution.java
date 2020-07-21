/*
https://leetcode.com/problems/happy-number/

Write and algorithm to determine if a number n is "happy".

A happy number is a number defined by the follow process:
Starting with any positive integer, replace the number by the sum of
the squares of its digits, and repeat the process until the number
equals 1 (where it will stay), or it loops endlessly in a cycle which
does not include 1. Those numbers for which this process ends in 1 are
happy numbers.

Return true is n is a happy number, and false if not.
*/

import java.util.*;

public class Solution {

    // My solution used a Set to keep track of sums we've seen in order
    // to detect a cycle
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int sum = n;

        while (!seen.contains(sum)) {
            seen.add(sum);
            sum = sumSquares(sum);
            if (sum == 1) {
                return true;
            }
        }

        return false;
    }

    // This solution uses the same approach used to find a cycle in a
    // linked list with a slow and fast pointer that will eventually
    // be equal.
    public boolean isHappy_twoPointer(int n) {
        int slow = sumSquares(n);
        int fast = sumSquares(sumSquares(n));

        while (slow != fast) {
            slow = sumSquares(slow);
            fast = sumSquares(sumSquares(fast));
        }

        return slow == 1;
    }

    private int sumSquares(int n) {
        int sum = 0;
        int curr = n;

        while (curr > 0) {
            int num = curr % 10;
            sum += num * num;
            curr /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input = {
            19, // true
            2, // false
        };

        for (int i : input) {
            System.out.println(sol.isHappy_twoPointer(i));
        }
    }
    
}