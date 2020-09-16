import java.util.Stack;

/**
 * https://leetcode.com/problems/plus-one/
 * 
 * Given a non-empty array of digits representing a non-negative integer,
 * add one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head
 * of the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 */
public class Solution {

    // My solution reads the input array from right to left, addeding 1
    // and carrying over as necessary, adding the resulting digits to a 
    // stack to be read back out at the end.
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        boolean added = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (!added) {
                if (i == 0) {
                    if (digits[i] == 9) {
                        stack.push(0);
                        stack.push(1);
                    } else {
                        stack.push(digits[i] + 1);
                    }
                } else if (digits[i] == 9) {
                    stack.push(0);
                } else {
                    stack.push(digits[i] + 1);
                    added = true;
                }
            } else {
                stack.push(digits[i]);
            }
        }
        // Construct output array from stack
        int[] plusOne = new int[stack.size()];
        for (int i = 0; i < plusOne.length; i++) {
            plusOne[i] = stack.pop();
        }
        return plusOne;
    }

    // Elegant solution from discussion board. This solution similarly
    // goes from right to left through the array adding 1 as necessary.
    // However the solution of creating a new 0-filled array and appending a
    // 1 to the front for the edge case where all digits are 9 is elegant.
    public int[] plusOneElegant(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        // This is for edge case where all digits are 9
        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
            {1, 2, 3}, // {1, 2, 4}
            {4, 3, 2, 1}, // {4, 3, 2, 2}
            {1, 9, 9}, // {2, 0, 0}
            {9} // {1, 0}
        };

        for (int[] test : testCases) {
            for (int i : sol.plusOne(test)) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
    
}