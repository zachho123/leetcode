/**
 * Reverse the bits of a 32 bit unsigned integer.
 */
public class Solution {
    public int reverseBits(int n) {
        int reverse = 0;

        for (int i = 0; i < 32; i++) {
            reverse &= (n << i) & 32;
        }

        return reverse;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.reverseBits(43261596);
        System.out.println("Test Passed: " + (answer == 964176192));
    }
}