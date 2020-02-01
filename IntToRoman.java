package main.java.leetCode;

/**
 * Created by qiuqian on 3/14/17.
 */
public class IntToRoman {

    public String intToRoman(int num) {

        String[] for1000 = {"","M","MM","MMM"};
        String[] for100 = {"", "C", "CC","CCC", "CD","D","DC","DCC","DCCC","CM"};
        String[] for10 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] for1 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return for1000[num/1000] + for100[(num%1000)/100]+for10[(num%100)/10]+for1[num%10];

    }

    public static String[] generate(int scale, char c, char c5, char c10){
        String[] result = new String[10];
        result[0] = "";
        int i = 1;

        while(i < 4){
            result[i] = result[i-1] + c ;
            i++;
        }

        result[i++] = c + "" + c5;

        result[i++] = c5 +"";
        while(i%5 < 4){
            result[i] = result[i-1] + c;
            i++;
        }
        result[9] = c + "" + c10;

        return result;
    }

}
