/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 */

public class LongestPalindrome {

    // O(n^3) time complexity
    public String bruteForce(String s) {
        int maxLength = 0;
        String palindrome = "";

        for (int start = 0; start < s.length(); start++) {
            for (int end = s.length(); end > start; end--) {
                String sub = s.substring(start,end);
                if (sub.length() > maxLength && isPalindrome(sub)) {
                    maxLength = sub.length();
                    palindrome = sub;
                }
            }
        }

        return palindrome;
    }

    private boolean isPalindrome(String s) {
        int start;
        int end;
        boolean isPalindrome;

        if (s.length() == 1) {
            isPalindrome = true;
        } else {
            isPalindrome = true;
            start = 0;
            end = s.length()-1;

            while (isPalindrome && start <= end) {
                if (s.charAt(start) != s.charAt(end)) {
                    isPalindrome = false;
                }
                start++;
                end--;
            }
        }

        return isPalindrome;
    }

    // O(n^2) time complexity
    public String expand(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();

        //System.out.println(solution.bruteForce("cbbd"));
        //System.out.println(solution.expand("acacacb"));
    }
}
