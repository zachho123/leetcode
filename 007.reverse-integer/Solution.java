/*
https://leetcode.com/problems/reverse-integer/

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Ouput 21

Assume we can only store integers within 32-bit signed int range.
Assume your function returns 0 when the reversed integer overflows.

*/
import java.util.Scanner;

public class Solution {

    public int reverse(int x) {
        return myReverse(x);
    }

    private int myReverse(int x) {
        int input = Math.abs(x);
        int output = 0;
        int pop;

        while (input != 0) {
            pop = input % 10;
            try {
                output = Math.multiplyExact(output, 10);
                output = Math.addExact(output, pop);
            } catch (ArithmeticException e) {
                return 0;
            }
            input /= 10;
        }

        return x > 0 ? output : output * -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // int[] testCases = { 123, -123, 120 };
        //
        // for (int i : testCases) {
        //     System.out.println(sol.reverse(i) + "\n");
        // }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number to reverse, or 'q' to quit");
        String input = "";

        while (!input.equalsIgnoreCase("q")) {
            input = in.nextLine();
            if (!input.equalsIgnoreCase("q")) {
                System.out.println(sol.reverse(Integer.valueOf(input)));
            }
        }
    }
}
