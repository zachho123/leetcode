/*
https://leetcode.com/problems/pascals-triangle/

Given a non-negative integer numRows, generate the first numRows of Pascal's
triangle.

In Pascal's triangle, each number is the sum of the two numbers directly
above it.
*/
import java.util.*;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer> sums = new LinkedList<>();

        for (int i = 0; i < numRows; i++) {
            int rowIdx = 0;
            int rowSize = i + 1;
            List<Integer> row = new ArrayList<Integer>(rowSize);
            int curr = 0;
            int last = 0;

            while (rowIdx < rowSize) {
                // if start or end of triangle row, value is 1
                if (rowIdx == 0 || rowIdx == rowSize - 1) {
                    curr = 1;
                } else {
                    curr = sums.remove();
                }

                // if start of row, don't calc sum
                if (last != 0) {
                    sums.add(curr + last);
                }

                row.add(curr);
                last = curr;
                rowIdx++;
            }
            // reset last to indicate start of row
            last = 0;

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<Integer>> list = sol.generate(5);

        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }
}