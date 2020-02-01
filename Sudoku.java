package main.java.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by qiuqian on 7/13/19.
 */
class Sudoku {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] subs = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    subs[indexToSubID(i, j)][num] = true;
                }
            }
        }

        dfs(board, rows, cols, subs, 0, 0);
    }

    boolean dfs(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] subs, int r, int c) {
        if (r == 9) {
            return true;
        }
        if (c == 9) {
            return dfs(board, rows, cols, subs, r + 1, 0);
        }
        if (board[r][c] != '.') return dfs(board, rows, cols, subs, r, c + 1);

        for (int i = 0; i < 9; i++) {
            int subId = indexToSubID(r, c);
            if (rows[r][i] || cols[c][i] || subs[subId][i]) {
                continue;
            } else {
                board[r][c] = (char)(i + '1');
                rows[r][i] = true;
                cols[c][i] = true;
                subs[subId][i] = true;
                if (dfs(board, rows, cols, subs, r, c + 1)) return true;
                board[r][c] = '.';
                rows[r][i] = false;
                cols[c][i] = false;
                subs[subId][i] = false;
            }
        }
        return false;
    }

    private int indexToSubID(int i, int j) {
        return (i / 3) * 3 + j / 3;
    }

    static void print(char[][] board) {
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] strs = {"..9748...", "7........", ".2.1.9...",
                "..7...24.", ".64.1.59.", ".98...3..",
        "...8.3.2.", "........6", "...2759.."};
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            board[i] = strs[i].toCharArray();
        }
        print(board);
        System.out.println();
        Sudoku test = new Sudoku();
        test.solveSudoku(board);
        print(board);
    }
}
