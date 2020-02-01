package main.java.leetCode;

import main.java.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuqian on 12/19/17.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = restoreIpAddresses(s, 4);
        return result;
    }

    public List<String> restoreIpAddresses(String s, int number) {
        List<String> result = new ArrayList<String>();
        if(s.length() <= 0 || s.length() > 3 * number) {
            return result;
        }

        //Error point: "010010" -> ["0.1.0.010","0.1.00.10","0.1.001.0","0.10.0.10","0.10.01.0","0.100.1.0","01.0.0.10","01.0.01.0","01.00.1.0","010.0.1.0"] is wrong
        int lowerBound = s.length() - 3 * (number - 1);
        //Error point: should consider when lowerBound < 1
        int i = (lowerBound > 1) ? lowerBound : 1;

        while(i <= s.length() - (number - 1)) {
            String first = s.substring(0, i);
            if(Integer.parseInt(first) > 255 || (first.length() > 1 && first.charAt(0) == '0')) {
                break;
            }
            if(number == 1) {
                result.add(s);
                return result;
            }
            List<String> remainSplit = restoreIpAddresses(s.substring(i), number - 1);

            for (String split : remainSplit) {
                result.add(first.concat("." + split));
            }
            i++;
        }

        return result;

    }

    public static void main(String[] args) {
        RestoreIPAddresses test = new RestoreIPAddresses();
        List<String> result = test.restoreIpAddresses("010010");
        for(String s: result) {
            System.out.println(s);
        }
    }
}
