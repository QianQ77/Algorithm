package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 8/20/17.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        if(numRows == 0){
            return result;
        }


        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> newlist = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    newlist.add(1);
                }else{
                    newlist.add(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }

            }
            result.add(newlist);

        }
        return result;

    }

    public static void main(String[] args){
        PascalTriangle test = new PascalTriangle();
        test.generate(10);
    }
}
