/**
 * Given two integers, divide the two integers without using multiplication,
 * division, and mod operator.
 * 
 * Return the integer quotient (rounded down).
 * 
 * Assume your function returns 2^31 - 1 when the division result overflows.
 */
public class Solution {
    public int divide(int dividend, int divisor) {

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] inputs = {
            {10, 3, 3},
            {7, -3, -2},
            {0, 1, 0},
            {1, 1, 1}
        };

        for (int[] in : inputs) {
            int result = s.divide(in[0], in[1]);
            System.out.println("Expected:" + in[2] + " Got:" + result);
        }
    }
}