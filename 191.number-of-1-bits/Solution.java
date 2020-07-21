/*
https://leetcode.com/problems/number-of-1-bits/

Write a function that takes an unsigned integer and return the number of '1'
bits it has (also known as the Hamming weight).

Note:
- Note that in some languages such as Java, there is no unsigned integer type.
In this case, the input will be given as a signed integer type and should not
affect your implementation, as the internal binary representation of the
Integer is the same whether it is signed or unsigned.
- In Java, the compiler represents that signed integers using 2's complement
notation.
*/

public class Solution {

    public int hammingWeight(int n) {
        int hammingWeight = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                hammingWeight++;
            }
            n = n >>> 1;
        }

        return hammingWeight;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input = {0, 1, 3};

        for (int in : input) {
            System.out.println(sol.hammingWeight(in));
        }
    }
}