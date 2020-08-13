package club.cser.leetcode;

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> sudoku = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' != board[i][j]
                        && !(sudoku.add(String.format("row %d: %c", i, board[i][j]))
                        && sudoku.add(String.format("col %d: %c", j, board[i][j]))
                        && sudoku.add(String.format("cube %d-%d: %c", i/3, j/3, board[i][j])))) {
                    System.out.println(String.format("row %d,%d: %c", i, j, board[i][j]));
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        Set<Integer> sudoku = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' != board[i][j] &&
                        !( sudoku.add(encodeSudoku(0, i, board[i][j]))
                        && sudoku.add(encodeSudoku(1, j, board[i][j]))
                        && sudoku.add(encodeSudoku(2, i / 3 * 3 + j / 3, board[i][j]))
                        )
                ) {
                    System.out.println(String.format("row %d,%d: %c", i, j, board[i][j]));
                    return false;
                }
            }

        }
        return true;
    }
    private Integer encodeSudoku(int type, int ordinal, char ch) {
//        System.out.println(Integer.toBinaryString(((type * 9 + ordinal) << 9) | (1 << (ch - '1'))));
        return ((type * 9 + ordinal) << 9) | (1 << (ch - '1'));

    }

    public boolean isValidSudoku3(char[][] board) {
        int[] sudoku = new int[27];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' != board[i][j] &&
                        !( add(0, i, board[i][j], sudoku)
                                && add(1, j, board[i][j], sudoku)
                                && add(2, i / 3 * 3 + j / 3, board[i][j], sudoku)
                        )
                ) {
                    System.out.println(String.format("row %d,%d: %c", i, j, board[i][j]));
                    return false;
                }
            }

        }
        return true;
    }
    private boolean add(int type, int ordinal, char ch, int[] sudoku) {
        int r = type * 9 + ordinal;
        int code = 1 << (ch - '1');
        if ((sudoku[r] & code) != 0)
            return false;
        else {
            sudoku[r] = sudoku[r] | code;
            return true;
        }
    }
}
