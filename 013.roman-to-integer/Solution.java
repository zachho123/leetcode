/*
https://leetcode.com/problems/roman-to-integer/

Roman numerals are represented by seven different symbols: 
I: 1
V: 5
X: 10
L: 50
C: 100
D: 500
M: 1000

Special Cases:
- I can be placed before V and X to make 4 and 9
- X can be placed before L and C to make 40 and 90
- C can be placed before D and M to make 400 and 900
*/

public class Solution {

    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char next = i < s.length() - 1 ? s.charAt(i+1) : '#';

            if (c == 'I') {
                if (next == 'V') {
                    result += 4;
                    i++;
                } else if (next == 'X') {
                    result += 9;
                    i++;
                } else {
                    result += 1;
                }
            } else if (c == 'V') {
                result += 5;
            } else if (c == 'X') {
                if (next == 'L') {
                    result += 40;
                    i++;
                } else if (next == 'C') {
                    result += 90;
                    i++;
                } else {
                    result += 10;
                }
            } else if (c == 'L') {
                result += 50;
            } else if (c == 'C') {
                if (next == 'D') {
                    result += 400;
                    i++;
                } else if (next == 'M') {
                    result += 900;
                    i++;
                } else {
                    result += 100;
                }
            } else if (c == 'D') {
                result += 500;
            } else { // c == 'M' 
                result += 1000;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] input = {
            "III", // 3
            "IV", // 4
            "IX", // 9
            "LVIII", // 58
            "MCMXCIV" /// 1994
        };

        for (String s : input) {
            System.out.println(sol.romanToInt(s));
        }
    }
}