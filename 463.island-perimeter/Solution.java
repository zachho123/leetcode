/*
https://leetcode.com/problems/island-perimeter/

You are given a map in form of a two-dimensional integer grid where 1
represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is
completely surrounded by water, and there is exactly one island (i.e., one or
more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the
water around the island). One cell is a square with side length 1. The grid
is rectangular, width and height don't exceed 100. Determine the perimeter
of the island.
*/

public class Solution {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        boolean isIslandFound = false;
        final int NUM_BLOCK_EDGES = 4;
        // because shared edges are between 2 blocks, it's actually
        // removing 2 edges from the final perimeter
        final int SHARED_EDGE_WEIGHT = 2;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    perimeter += NUM_BLOCK_EDGES;

                    // check up for common edge
                    if (checkUp(row, col, grid)) {
                        perimeter -= SHARED_EDGE_WEIGHT;
                    }

                    // check left for common edge
                    if (checkLeft(row, col, grid)) {
                        perimeter -= SHARED_EDGE_WEIGHT;
                    }
                }
            }
        }

        return perimeter;
    }

    public boolean checkUp(int row, int col, int[][] grid) {
        if (row > 0 && grid[row-1][col] == 1) {
            return true;
        }

        return false;
    }

    public boolean checkLeft(int row, int col, int[][] grid) {
        if (col > 0 && grid[row][col-1] == 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input1 = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };

        int[][] input2 = {
            {0, 1, 1, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };

        int[][] input3 = {
            {1, 1, 1, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 1},
            {1, 1, 1, 0, 0}
        };

        System.out.println(sol.islandPerimeter(input1));
        System.out.println(sol.islandPerimeter(input2));
        System.out.println(sol.islandPerimeter(input3));
    }
}