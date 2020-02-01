package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 7/31/17.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();

        if(n < 4 && n != 1){          //error point: when n = 1 should return [["Q"]]
            return result;
        }
        ArrayList<Integer> occupiedCol = new ArrayList<Integer>();
        nQueenHelper(occupiedCol, result, n);
        return result;
    }

    public String generateString(int col, int n){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(i == col){
                builder.append("Q");
            }else{
                builder.append(".");
            }
        }
        return builder.toString();
    }

    public void nQueenHelper(ArrayList<Integer> occupiedCol, ArrayList<List<String>> result, int n){
        if(occupiedCol.size() == n){
            ArrayList<String> solution = new ArrayList<>();
            for(int col : occupiedCol){
                solution.add(generateString(col, n));
            }
            result.add(solution);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!occupiedCol.contains(i)){
                if(occupiedCol.size() != 0){
                    int lastCol = occupiedCol.get(occupiedCol.size() - 1);
                    if(i == lastCol - 1 || i == lastCol + 1){
                        continue;
                    }
                }
                occupiedCol.add(i);
                nQueenHelper(occupiedCol, result, n);
                occupiedCol.remove(occupiedCol.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        NQueens queens = new NQueens();
        List<List<String>> result = queens.solveNQueens(5);
    }
}
