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
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = (dividend > 0) == (divisor > 0);
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int quotient = 1;
        int min = 0;
        int max = absDividend;
        int half = max / 2;

        if (absDividend == 0 || absDivisor > absDividend) {
            return 0;
        }

        while (half > 0) {
            // int product = getProduct(absDivisor, half);
            int product = absDivisor * half;
            if (product == absDividend) {
                quotient = half;
                break;
            } else if (product < absDividend) {
                min = half;
                half = min + (max - min) / 2;
            } else {
                max = half;
                half = min + (max - min) / 2;
            }

            if (min == half) {
                quotient = half;
                break;
            }
        }

        return sign ? quotient : -quotient;
    }

    private int getProduct(int base, int multiplier) {
        int product = 0;

        for (int i = 0; i < multiplier; i++) {
            product += base;
        }

        return product;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] inputs = {
            {10, 3, 3},
            {7, -3, -2},
            {0, 1, 0},
            {1, 1, 1},
            {-1, 1, -1},
            {-1, -1, 1}
        };

        for (int[] in : inputs) {
            int result = s.divide(in[0], in[1]);
            System.out.println("Expected:" + in[2] + " Got:" + result);
        }
    }
}