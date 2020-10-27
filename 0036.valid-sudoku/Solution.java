public class Solution {
    /**
     * Determine if a 9x9 sudoku board is valid. Only the filled cells need to
     * be validated according to following rules:
     * 1. Each row must contain digits 1-9 without repetition
     * 2. Each column must contain the digits 1-9 without repetition
     * 3. Each of the 9 3x3 sub-boxes must contain 1-9 without repetition
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;

        return isValid;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][][] boards = {
            {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
            },
            {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
            }
        };

        for (char[][] board : boards) {
            System.out.println(s.isValidSudoku(board));
        }
    }
}