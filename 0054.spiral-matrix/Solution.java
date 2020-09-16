/*
https://leetcode.com/problems/spiral-matrix/

Given a matrix of m x n elements (m rows, n columns), return all elements
of the matrix in spiral order.
*/
import java.util.*;

public class Solution {

    public int upperBound;
    public int rightBound;
    public int lowerBound;
    public int leftBound;

    public List<Integer> spiralOrder(int[][] matrix) {
        return first(matrix);
    }

    private List<Integer> first(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        int count = 0;

        if (matrix.length == 0) {
            return output;
        }

        // init bounds
        upperBound = 0;
        lowerBound = matrix.length;
        leftBound = 0;
        rightBound = matrix[0].length;

        while (upperBound != lowerBound && leftBound != rightBound) {
            switch (count) {
                case 0:
                    readRight(output, matrix, upperBound);
                    break;
                case 1:
                    readDown(output, matrix, rightBound-1);
                    break;
                case 2:
                    readLeft(output, matrix, lowerBound-1);
                    break;
                case 3:
                    readUp(output, matrix, leftBound);
                    break;
            }
            count++;
            if (count > 3) count = 0;
        }

        return output;
    }

    private void readRight(List<Integer> output, int[][] matrix, int row) {
        for (int i = leftBound; i < rightBound; i++) {
            output.add(matrix[row][i]);
        }
        upperBound++;
    }

    private void readDown(List<Integer> output, int[][] matrix, int col) {
        for (int i = upperBound; i < lowerBound; i++) {
            output.add(matrix[i][col]);
        }
        rightBound--;
    }

    private void readLeft(List<Integer> output, int[][] matrix, int row) {
        for (int i = rightBound-1; i > leftBound-1; i--) {
            output.add(matrix[row][i]);
        }
        lowerBound--;
    }

    private void readUp(List<Integer> output, int[][] matrix, int col) {
        for (int i = lowerBound-1; i > upperBound-1; i--) {
            output.add(matrix[i][col]);
        }
        leftBound++;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("[1, 2, 3, 6, 9, 8, 7, 4, 5]");
        int[][] input1 = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println(sol.spiralOrder(input1));

        sol = new Solution();
        System.out.println("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]");
        int[][] input2 = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.println(sol.spiralOrder(input2));
    }
}
