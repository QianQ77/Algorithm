package main.java.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by qiuqian on 8/13/18.
 */
public class EvaluateDivition {

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = buildMap(equations, values);
        double[] results = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            results[i] = dfs(map, queries[i][0], queries[i][1], 1, new HashSet<String> ());
        }
        return results;
    }

    private static double dfs(Map<String, Map<String, Double>> map, String start, String target, double value,
                              HashSet<String> visited) {
        if(!map.containsKey(start) || !map.containsKey(target)) {
            return -1.0;
        }
        if (start.equals(target)) {
            return value;
        }

        Map<String, Double> neighbors = map.get(start);
        visited.add(start);

        for(String key : neighbors.keySet()) {
            if(visited.contains(key)) {
                continue;
            }

            double result = dfs(map, key, target, value * neighbors.get(key), visited);
            if(result != -1.0) {
                return result;
            }
        }
        return -1.0;

    }



    private static Map<String, Map<String, Double>> buildMap(String[][] equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0; i < values.length; i++) {

            map.putIfAbsent(equations[i][0], new HashMap<>());
            map.putIfAbsent(equations[i][1], new HashMap<>());
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        return map;
    }



    public static void main(String[] args) {
        String[][] equations = new String[][]{{"a", "b"}, {"b", "c"}};
        double[] values = new double[]{2.0, 3.0};
        String[][] queries = new String[][]{{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] results = EvaluateDivition.calcEquation(equations, values, queries);
        for (double result:
             results) {
            System.out.println(result);
        }
    }
}
