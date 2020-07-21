/*
https://leetcode.com/problems/string-to-integer-atoi/

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until
the first non-whitespace character is found. Then, starting from this character,
takes an optional initial plus or minus sign followed by as many numerical
digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the
integral number, which are ignored and have no effect on the behavior of
this function.

If the first sequence of non-whitespace characters in str is not a
valid integral number, or if no such sequence exists because either str is
empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:
    - Only the space character is considered as whitespace
    - Assume we can only store integers within 32-bit signed range, if the val
      is out of range, return INT_MAX or INT_MIN
*/
import java.util.HashSet;
import java.util.Arrays;

public class Solution {

    Character[] plusMinus = {'+', '-'};
    Character[] numerical = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    HashSet<Character> plusMinusSet = new HashSet<>(Arrays.asList(plusMinus));
    HashSet<Character> numericalSet = new HashSet<>(Arrays.asList(numerical));

    public int myAtoi(String s) {
        return firstAttempt(s);
    }

    private int firstAttempt(String s) {
        String trimmed = s.trim();
        boolean isNeg = false;
        int output = 0;
        int i = 0;

        if (trimmed.length() == 0) {
            return 0;
        }

        if (plusMinusSet.contains(trimmed.charAt(i))) {
            isNeg = trimmed.charAt(i) == '-' ? true : false;
            i = 1;
            // return 0 for invalid string if '-' is not followed by numbers
            if (trimmed.length() == 1 || !isNumerical(trimmed.charAt(i))) {
                return 0;
            }
        } else if (!isNumerical(trimmed.charAt(i))) {
            return 0;
        }

        // increment index for every valid numerical char
        while (i < trimmed.length() && isNumerical(trimmed.charAt(i))) {
            i++;
        }

        // pull the purely numerical substring
        String substring = isNeg ? trimmed.substring(1, i) : trimmed.substring(0, i);

        // parse to int, return MIN or MAX value if overflow occurs
        try {
            output = Integer.parseInt(substring);
        } catch (Exception e) {
            output = isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return isNeg ? output * -1 : output;
    }

    private boolean isNumerical(char c) {
        return numericalSet.contains(c);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] input = {
            "42",
            "   -42",
            "4193 with words",
            "words and 987",
            "-91283472332",
            "-words",
            "-",
            "",
            "+1"
        };

        for (String s : input) {
            System.out.println(sol.myAtoi(s));
        }
    }
}
