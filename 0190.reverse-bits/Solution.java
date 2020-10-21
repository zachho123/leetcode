/**
 * Reverse the bits of a 32 bit unsigned integer.
 */
public class Solution {
    public int reverseBits(int n) {
        int reverse = 0;
        
        for (int i = 0; i < 31; i++) {
            reverse += n & 1;
            n >>>= 1;
            if (i < 31) {
                reverse <<= 1;
            }
        }

        return reverse;
    }

    private String bin(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            if (((n & (1 << (31 - i))) >> (31 - i)) == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int input = 4294967293;
        System.out.println(s.bin(input));
        int answer = s.reverseBits(input);
        System.out.println(s.bin(answer));
    }
}