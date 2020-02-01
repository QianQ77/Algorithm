package main.java.leetCode;

/**
 * Created by qiuqian on 11/14/18.
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        if(S == null && T == null || S.length() == 0 && T.length() == 0) return true;
        if(S == null || T == null || S.length() == 0 || T.length() == 0) return true;
        int si = S.length() - 1;
        int ti = T.length() - 1;
        int sbCount = 0;
        int tbCount = 0;
        while(si >= 0 && ti >= 0) {
            if(S.charAt(si) != '#' && T.charAt(ti) != '#' && sbCount == 0 && tbCount == 0) {
                if(S.charAt(si) != T.charAt(ti))    return false;
                else {
                    si--;
                    ti--;
                }
            }else if(S.charAt(si) == '#') {
                sbCount++;
                si--;
            }else if(T.charAt(ti) == '#') {
                tbCount++;
                ti--;
            }else if(sbCount > 0) {
                sbCount--;
                si--;
            }else{
                tbCount--;
                ti--;
            }
        }
        if(si >= 0) return checkRemain(S, si, sbCount);
        return checkRemain(T, ti, tbCount);
    }

    private boolean checkRemain(String str, int index, int bCount) {
        while(index >= 0) {
            //if(bCount == 0) return false;
            if(str.charAt(index) == '#') {
                bCount++;
            }else {
                if(bCount == 0) return false;
                bCount--;
            }
            index--;
        }
        return bCount >= 0;
    }

    public static void main(String[] args) {
        BackspaceStringCompare test = new BackspaceStringCompare();
        System.out.println(test.backspaceCompare("j##yc##bs#srqpfzantto###########i#mwb",
                "j##yc##bs#srqpf#zantto###########i#mwb"));
    }
}
