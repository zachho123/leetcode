import java.util.*;

/**
 * Given n pairs of prentheses, write a function to generate all combinations
 * of well-formed parentheses.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        recurse(list, new char[2 * n], 0, 0, 0);
        return list;
    }

    private void recurse(List<String> list, char[] arr, int curr, int open,
            int close) {
        int numPairs = arr.length / 2;
        
        if (curr >= arr.length) {
            list.add(new String(arr));
            return;
        }

        if (open < numPairs) {
            arr[curr] = '(';
            recurse(list, arr, curr + 1, open + 1, close);
        }
        if (close < open) {
            arr[curr] = ')';
            recurse(list, arr, curr + 1, open, close + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> out = s.generateParenthesis(3);
        System.out.println(out.toString());
    }
}