package main.java.leetCode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by qiuqian on 8/14/17.
 */
public class LRUCache {

    private int capacity;
    private int size;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    private class Node {
        Node prev;
        Node next;
        Integer key;
        Integer val;
        Node(Node prev, Node next, Integer key, Integer val) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        size = 0;
        head = null;
        tail = null;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            moveToTail(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            moveToTail(map.get(key));
            map.get(key).val = value;
        }else if(size < capacity){
            map.put(key, addToTail(key, value));
            //error point
            size++;
        }else {
            removeFromHead();
            map.put(key, addToTail(key, value));

        }
    }

    public void removeFromHead() {
        Node oldHead = head;
        head = oldHead.next;
        //error point: should check if head == null
        if(head != null)
            head.prev = null;
        oldHead.prev = null;
        oldHead.next = null;
        map.remove(oldHead.key);
        //error point: should check if tail == oldHead
        if(tail == oldHead) {
            tail = null;
        }
    }

    public Node addToTail(Integer key, Integer value) {
        Node newNode = new Node(tail, null, key, value);
        tail = newNode;
        if(tail.prev == null) {
            head = tail;
        }else {
            tail.prev.next = newNode;
        }
        return newNode;
    }

    public void moveToTail(Node node) {
        if(tail == node) {
            return;
        }
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        tail.next = node;
        //error point: should consider head
        if(head == node) {
            head = node.next;
        }
        node.prev = tail;
        node.next = null;
        tail = node;
        map.put(node.key, node);

    }


    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get 1: " + cache.get(1));
        cache.put(3, 3);
        System.out.println("get 2: " + cache.get(2));      // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println("get 1: " + cache.get(1));       // returns -1 (not found)
        System.out.println("get 3: " + cache.get(3));       // returns 3
        System.out.println("get 4: " + cache.get(4));       // returns 4

        System.out.println();

        LRUCache cache2 = new LRUCache(1);
        cache2.put(2, 1);
        System.out.println("get 2: " + cache2.get(2));      // returns 1
        cache2.put(3, 2);
        System.out.println("get 2: " + cache2.get(2));      // returns -1 (not found)
        System.out.println("get 3: " + cache2.get(3));       // returns 2
        System.out.println("get 4: " + cache2.get(4));      // returns -1 (not found)

        System.out.println();

        LRUCache cache3 = new LRUCache(1);
        cache3.put(1, 1);
        cache3.put(2, 2);
        System.out.println("get 1: " + cache3.get(1));      // returns -1 (not found)
        cache3.put(3, 3);
        System.out.println("get 2: " + cache3.get(2));      // returns -1 (not found)
        cache3.put(4, 4);    // evicts key 1
        System.out.println("get 1: " + cache3.get(1));       // returns -1 (not found)
        System.out.println("get 3: " + cache3.get(3));       // returns -1 (not found)
        System.out.println("get 4: " + cache3.get(4));       // returns 4
    }
}

