package main.java.leetCode;

import java.util.HashSet;

/**
 * Created by qiuqian on 10/19/17.
 */
public class ValidSodoku {
    enum CheckType {ROW, COL, SQUARE};

    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9){
            return false;
        }
        for(int i = 0; i < 9; i++){
            if(!check(board, i, CheckType.ROW) || !check(board, i, CheckType.COL) || !check(board, i, CheckType.SQUARE)){
                return false;
            }
        }
        return true;

    }

    public boolean check(char[][] board, int i, CheckType type){
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        switch(type) {
            case ROW:
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] != '.'){
                        set.add(board[i][j]);
                        count++;
                    }
                }
                break;
            case COL:
                for(int j = 0; j < board[0].length; j++){
                    if(board[j][i] != '.'){
                        set.add(board[j][i]);
                        count++;
                    }
                }
                break;
            case SQUARE:
                int row = 3 * (i / 3);
                int col = 3 * (i % 3);
                for(int p = 0; p < 3; p++){
                    row = row + p;
                    for(int q = 0; q < 3; q++){
                        col = col + q;
                        if(board[row][col] != '.'){
                            set.add(board[row][col]);
                            count++;
                        }
                    }
                }
                break;
        }

        if(count != set.size()){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{".87654321".toCharArray(), "2........".toCharArray(), "3........".toCharArray(),
                "4........".toCharArray(), "5........".toCharArray(), "6........".toCharArray(), "7........".toCharArray(),
                "8........".toCharArray(), "9........".toCharArray()};
        ValidSodoku test = new ValidSodoku();
        test.isValidSudoku(board);
    }
}
