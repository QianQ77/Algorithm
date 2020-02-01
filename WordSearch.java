package main.java.leetCode;

import sun.jvm.hotspot.utilities.Assert;

/**
 * Created by qiuqian on 9/9/18.
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) {
            return true;
        }
        if(board == null || board.length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(backtracking(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtracking(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if(index == word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        if (backtracking(board, word, visited, i - 1, j, index + 1)) return true;
        if (backtracking(board, word, visited, i + 1, j, index + 1)) return true;
        if (backtracking(board, word, visited, i, j - 1, index + 1)) return true;
        if (backtracking(board, word, visited, i, j + 1, index + 1)) return true;
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(chars, "ABCB") == false);
        System.out.println(exist(chars, "ABCCED") == true);
    }
}
