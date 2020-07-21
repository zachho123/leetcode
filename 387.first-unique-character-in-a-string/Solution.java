/*
https://leetcode.com/problems/first-unique-character-in-a-string/

Given a string, find the first non-repeating character in it and return
it's index. If it doesn't exist, return -1.

Note: You may assume the string contain only lowercase letters.
*/

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Solution {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        } else if (s.length() == 1) {
            return 0;
        }

        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            charCounts[idx]++;
        }

        for (int j = 0; j < s.length(); j++) {
            int idx = s.charAt(j) - 'a';
            if (charCounts[idx] == 1) {
                return j;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] input = {
            "leetcode", // 0
            "loveleetcode", // 2
            "aabbcc", // -1
            "lolobmbmz", // 8
            "loolbmbm", // -1
            "" // -1
        };

        for (String s : input) {
            System.out.println(sol.firstUniqChar(s));
        }
    }
}