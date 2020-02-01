package main.java.leetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by qiuqian on 9/16/18.
 */
public class RandomizedSet {
    int size;
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        size = 0;
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, size);
        size++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        //error point: should check if index == size -1
        int index = map.get(val);
        if(index != size - 1) {
            list.set(index, list.get(size - 1));
            map.put(list.get(index), index);
        }
        list.remove(size - 1);
        map.remove(val);

        size--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get((int)(Math.random() * size));
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.remove(0));
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));
        System.out.println(set.getRandom());
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));
    }
}
