public class Solution {

    public int numIslands(char[][] grid) {
        int numIslands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    numIslands++;
                    dfs(grid, row, col);
                }
            }
        }

        return numIslands;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length &&
                col >= 0 && col < grid[0].length &&
                grid[row][col] == '1') {
            grid[row][col] = '0';

            // Check up, left, right, down
            dfs(grid, row - 1, col);
            dfs(grid, row, col - 1);
            dfs(grid, row, col + 1);
            dfs(grid, row + 1, col);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] input = {
            "11000".toCharArray(),
            "11000".toCharArray(),
            "00100".toCharArray(),
            "00011".toCharArray()
        };

        System.out.println(s.numIslands(input));
    }
}