package main.java.leetCode;

import java.util.*;

/**
 * Created by qiuqian on 7/14/19.
 */
public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Set<String> set = new HashSet<>();
        for (String skill : req_skills) {
            set.add(skill);
        }
        List<Integer> result = helper(new ArrayList<>(), set, people, 0);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public List<Integer> helper(List<Integer> list, Set<String> req_skills, List<List<String>> people, int index) {
        if (req_skills.isEmpty()) {
            return new ArrayList<>(list);
        } else if (index == people.size()) {
            return null;
        }
        list.add(index);
        for (String skill : people.get(index)) {
            req_skills.remove(skill);
        }
        List<Integer> addThis = helper(list, req_skills, people, index + 1);
        list.remove(list.size() - 1);
        for (String skill : people.get(index)) {
            req_skills.add(skill);
        }
        List<Integer> notAddThis = helper(list, req_skills, people, index + 1);

        if (addThis == null) {
            return notAddThis;
        }
        if (notAddThis == null) {
            return addThis;
        }
        if (addThis.size() > notAddThis.size()) {
            return notAddThis;
        }
        return addThis;
    }

    public static void main(String[] args) {
        SmallestSufficientTeam test = new SmallestSufficientTeam();
        String[] req_skills = {"gvp","jgpzzicdvgxlfix","kqcrfwerywbwi","jzukdzrfgvdbrunw","k"};
        List<List<String>> people = new ArrayList<>();
        people.add(new ArrayList<>());
        people.add(new ArrayList<>());
        people.add(new ArrayList<>());
        people.add(new ArrayList<>());
        people.add(new ArrayList<>(Arrays.asList("jgpzzicdvgxlfix")));
        people.add(new ArrayList<>(Arrays.asList("jgpzzicdvgxlfix","k")));
        people.add(new ArrayList<>(Arrays.asList("jgpzzicdvgxlfix","kqcrfwerywbwi")));
        people.add(new ArrayList<>(Arrays.asList("gvp")));
        people.add(new ArrayList<>(Arrays.asList("jzukdzrfgvdbrunw")));
        people.add(new ArrayList<>(Arrays.asList("gvp","kqcrfwerywbwi")));
        Arrays.toString(test.smallestSufficientTeam(req_skills, people));
    }
}
