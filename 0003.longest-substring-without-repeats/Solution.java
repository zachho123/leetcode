/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without
repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3
*/
import java.util.HashSet;
import java.util.HashMap;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        //return bruteForce(s);
        return second(s);
    }

    private int bruteForce(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            int count = 1;
            int j = i + 1;

            while (j < s.length() && set.add(s.charAt(j))) {
                j++;
                count++;
            }

            if (count > max) {
                max = count;
            }
            set.clear();
        }

        return max;
    }

    private int second(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        int marker = -1;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.containsKey(curr) && map.get(curr) >= marker) {
                marker = map.get(curr) + 1;
                map.put(curr, i);
                count = i - marker + 1;
            } else {
                map.put(curr, i);
                count++;
            }

            max = Math.max(count, max);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input1 = "abcabcbb"; // expected 3
        String input2 = "bbbbb"; // expected 1
        String input3 = "pwwkew"; // expected 3
        String input4 = "bacbdefg"; // expected 7
        String input5 = "ckilbkd"; // expected 5
        String input6 = "abba"; // expected 2

        System.out.println("input1 length: " + sol.lengthOfLongestSubstring(input1));
        System.out.println("input2 length: " + sol.lengthOfLongestSubstring(input2));
        System.out.println("input3 length: " + sol.lengthOfLongestSubstring(input3));
        System.out.println("input4 length: " + sol.lengthOfLongestSubstring(input4));
        System.out.println("input5 length: " + sol.lengthOfLongestSubstring(input5));
        System.out.println("input6 length: " + sol.lengthOfLongestSubstring(input6));
    }
}
