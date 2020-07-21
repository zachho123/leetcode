/*
https://leetcode.com/problems/sum-of-two-integers/

Calculate the sum of two integers a and b, but you are not allowed to use
the operator + and -.
*/

public class Solution {

    // This solution utilizes bit manipulation. The steps are:
    // 1. determine carries -> C = A && B
    // 2. set A to the different bits -> A = A ^ B
    // 3. shift carries over a bit and set to B -> B = C << 1
    // 4. repeat until carries = 0
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input = {
            {0, 0},
            {0, 1},
            {5, 5},
            {5, 6},
            {-2, 3}
        };

        for (int[] in : input) {
            System.out.println(sol.getSum(in[0], in[1]));
        }
    }
}