import java.util.*;

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
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> quadrants = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> quadSet = new HashSet<>();
            rows.add(rowSet);
            cols.add(colSet);
            quadrants.add(quadSet);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char currChar = board[row][col];
                if (currChar != '.') {
                    int quadrant = getQuadrant(row, col);
                    Set<Character> rowSet = rows.get(row);
                    Set<Character> colSet = cols.get(col);
                    Set<Character> quadSet = quadrants.get(quadrant);

                    if (isRepeatPresent(rowSet, colSet, quadSet, currChar)) {
                        return false;
                    } else {
                        rowSet.add(currChar);
                        colSet.add(currChar);
                        quadSet.add(currChar);
                    }
                }
            }
        }

        return true;
    }

    private int getQuadrant(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }

    private boolean isRepeatPresent(Set<Character> rowSet,
            Set<Character> colSet, Set<Character> quadSet, char currChar) {
        if (rowSet.contains(currChar) || colSet.contains(currChar) || 
                quadSet.contains(currChar)) {
            return true;
        }

        return false;
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