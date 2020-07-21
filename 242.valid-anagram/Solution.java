/*
https://leetcode.com/problems/valid-anagram/

Given two strings s and t , write a function to determine if t is an 
anagram of s.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your
solution to such case?
*/

import java.util.Arrays;

public class Solution {

    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }

    //     char[] s_sorted = s.toCharArray();
    //     char[] t_sorted = t.toCharArray();

    //     Arrays.sort(s_sorted);
    //     Arrays.sort(t_sorted);

    //     for (int i = 0; i < s.length(); i++) {
    //         if (s_sorted[i] != t_sorted[i]) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] chars = new int[26];
        int index = 0;

        for (char c : s.toCharArray()) {
            index = c - 'a';
            chars[index]++;
        }

        for (char c : t.toCharArray()) {
            index = c - 'a';
            if (chars[index] - 1 < 0) {
                return false;
            }
            chars[index]--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String i1 = "anagram";
        String i2 = "nagaram";

        String i3 = "rat";
        String i4 = "car";

        System.out.println(sol.isAnagram(i1, i2));
        System.out.println(sol.isAnagram(i3, i4));
    }
}