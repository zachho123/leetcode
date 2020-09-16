/**
https://leetcode.com/problems/count-and-say/

The count-and-say sequence is the sequence of integers with the first five
terms as following:
1.  1
2.  11
3.  21
4.  1211
5.  111221
6.  312211
7.  13112221
8.  1113213211
9.  31131211131221
10. 13211311123113112211

Given an integer n where 1 <= n <= 30, generate the nth term of the
count-and-say sequence. You can do so recursively, in other words from the
previous member read off the digits, counting the number of digits in groups
of the same digit.

Note: Each term of the sequence of integers will be represented as a string.
 */
public class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder();
        String prev = countAndSay(n - 1);
        int currCount = 0;
        char currChar = prev.charAt(0);

        for (int i = 0; i < prev.length(); i++) {
            if (prev.charAt(i) == currChar) {
                currCount++;
            } else {
                sb.append(currCount);
                sb.append(currChar);
                currChar = prev.charAt(i);
                currCount = 1;
            }
        }

        sb.append(currCount);
        sb.append(currChar);

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input = {1, 2, 3, 4, 5};

        for (int i : input) {
            System.out.println(sol.countAndSay(i));
        }
    }
    
}