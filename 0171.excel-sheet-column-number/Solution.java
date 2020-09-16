/*
https://leetcode.com/problems/excel-sheet-column-number/

Given a column title as appear in an Excel sheet, return its corresponding
column number.
*/

public class Solution {

    public int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }

        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] input = {
            "A", // 1
            "AB", // 28
            "ZY" // 701
        };

        for (String s : input) {
            System.out.println(sol.titleToNumber(s));
        }
    }
}