package main.java.leetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by qiuqian on 10/9/17.
 */
public class Isomophic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        ArrayList<Integer> countsS = getCountsForEachChar(s);
        ArrayList<Integer> countsT = getCountsForEachChar(t);
        if(countsS.size() != countsT.size()){
            return false;
        }
        for(int i = 0; i < countsS.size(); i++){
            if(countsS.get(i) != countsT.get(i)){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> getCountsForEachChar(String s){
        HashMap<Character, Integer> mapS = new HashMap<>();
        for(char c : s.toCharArray()){
            int count = mapS.getOrDefault(c, 0);
            mapS.put(c, count + 1);
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>(mapS.values());
        Collections.sort(arrayList);
        return arrayList;
    }
}
