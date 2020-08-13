package club.cser.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SudokuSolver {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j) {
        for (; i < 9; ++ i) {
            for (; j < 9; ++ j) {
                if (board[i][j] != '.')
                    continue;
                for (char k = '1'; k <= '9'; k++) {
                    board[i][j] = k;
                    if (isValidSudoku(board, i, j) && dfs(board, i, j))
//                    if (isValidSudoku(board) && dfs(board, i, j))
                        return true;
                }
                board[i][j] = '.';
                return false;
            }
            j = 0;
        }
        return true;
    }

    // 填下该字符时，只影响关联的方格，不用全部检测。
    private boolean isValidSudoku(char[][] board, int i, int j) {

        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][j] == board[i][k])
                return false;
            if (k != i && board[i][j] == board[k][j])
                return false;
        }

        for (int m = i / 3 * 3; m <  i / 3 * 3 + 3; ++ m) {
            for (int n = j / 3 * 3; n <  j / 3 * 3 + 3; ++ n) {
                if (m != i && n != j && board[m][n] == board[i][j])
                    return false;
            }
        }
        return true;
    }

    // 这个不行，不知道为啥，idea停不下来
    private boolean isValidSudoku1(char[][] board, int i, int j) {
        Set<String> sudoku = new HashSet<>();
        int cubeRow = i / 3 * 3;
        int cubeCol = j / 3 * 3;

        for (int k = 0; k < 9; k++) {
            if ('.' != board[i][k] && !sudoku.add(String.format("row %d: %c", i, board[i][k])))
                return false;
            if ('.' != board[k][j] && !sudoku.add(String.format("col %d: %c", j, board[k][j])))
                return false;
            int m = cubeRow + k / 3;
            int n = cubeCol + k % 3;
            if ('.' != board[m][n] && !sudoku.add(String.format("cube %d-%d: %c", m, n, board[m][n])))
                return false;
        }
//        System.out.println(Arrays.stream(board).map(Arrays::toString).reduce((a, b) -> a + b).get());

        return true;

    }

    // 直接用36题检查全部棋盘，LeetCode超时
    private boolean isValidSudoku(char[][] board) {
        Set<String> sudoku = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' != board[i][j]
                        && !(sudoku.add(String.format("row %d: %c", i, board[i][j]))
                        && sudoku.add(String.format("col %d: %c", j, board[i][j]))
                        && sudoku.add(String.format("cube %d-%d: %c", i/3, j/3, board[i][j])))) {
//                    System.out.println(String.format("row %d,%d: %c", i, j, board[i][j]));
                    return false;
                }
            }

        }
        return true;
    }
}