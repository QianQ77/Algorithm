package main.java.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qiuqian on 8/24/18.
 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < Math.pow(2, word.length()); i++) {
            String string = "";
            int oneCount = 0;
            for(int j = 0; j < word.length(); j++) {
                if((i >> j & 1) == 1){
                    oneCount++;
                } else {
                    if(oneCount != 0) {
                        string += oneCount;
                        oneCount = 0;
                    }
                    string += word.charAt(j);
                }
            }
            if(oneCount != 0) {
                string += oneCount;
            }
            result.add(string);
        }

        return result;
    }

    public List<String> generateAbbreviations2(String word) {
        // Write your code here
        List<String> results = new ArrayList<String>();
        helper2(results, "", word, 0, 0);
        return results;

    }

    public void helper2(List<String> results, String string, String word, int start, int oneCount) {
        if(start == word.length()) {
            if(oneCount != 0) {
                string += oneCount;
            }
            results.add(string);
            return;
        }

        helper2(results, string, word, start + 1, oneCount + 1);
        if(oneCount != 0) {
            string += oneCount;
        }
        string += word.charAt(start);
        helper2(results, string, word, start + 1, 0);
    }

    public List<String> generateAbbreviations3(String word) {
        // Write your code here
        List<String> results = new ArrayList<String>();
        helper3(results, new StringBuilder(), word, 0, 0);
        return results;

    }

    public void helper3(List<String> results, StringBuilder builder, String word, int start, int oneCount) {
        int len = builder.length();
        if(start == word.length()) {
            if(oneCount != 0) {
                builder.append(oneCount);
            }
            results.add(builder.toString());
        } else {
            helper3(results, builder, word, start + 1, oneCount + 1);
            if(oneCount != 0) {
                builder.append(oneCount);
            }
            builder.append(word.charAt(start));
            helper3(results, builder, word, start + 1, 0);
        }
        builder.setLength(len);

    }

    public static void main(String[] args) {
        GeneralizedAbbreviation test = new GeneralizedAbbreviation();

        List<String> result = test.generateAbbreviations("word");
        List<String> expected = Arrays.asList(new String[]{
                "1o1d","1o2","1or1","1ord","2r1","2rd","3d",
                "4","w1r1","w1rd","w2d","w3","wo1d","wo2","wor1","word"});
    }
}
