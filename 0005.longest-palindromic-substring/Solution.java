/***
 * Given a string s, find the longest palindromic substring in s.
 */
public class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] p1 = expand(s, i, i);
            int[] p2 = expand(s, i, i + 1);

            if (p1[2] > maxLen) {
                start = p1[0];
                end = p1[1];
                maxLen = p1[2];
            }

            if (p2[2] > maxLen) {
                start = p2[0];
                end = p2[1];
                maxLen = p2[2];
            }
        }

        return maxLen > 0 ? s.substring(start, end + 1) : "";
    }

    private int[] expand(String s, int left, int right) {
        int start = 0;
        int end = 0;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            start = left;
            end = right;
            left--;
            right++;
        }

        return new int[] {start, end, end - start + 1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] tests = {
            "babad",
            "cbbd",
            ""
        };
        String[] outputs = {
            "bab",
            "bb",
            ""
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.println("\nrunning test...");
            String result = s.longestPalindrome(tests[i]);
            boolean passed = result.equals(outputs[i]);
            System.out.println("got: " + result);
            System.out.println("test passed: " + passed);
        }
    }
}