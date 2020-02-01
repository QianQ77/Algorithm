package main.java.leetCode;

import main.java.util.ListNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qiuqian on 10/9/17.
 */
public class PandromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>();

        ListNode current = head;
        while(current != null){
            list.add(current.val);
            current = current.next;
        }

        for(int i = 0; i < list.size() / 2; i++){
            if(list.get(i) != list.get(list.size() - i - 1)){
                return false;
            }
        }
        return true;
    }
    public static boolean isP(){
        List<Integer> list = Arrays.asList(-129, -129);

        for(int i = 0; i < list.size() / 2; i++){
            Integer i1 = list.get(i);
            Integer i2 = list.get(list.size() - i - 1);
            //int i3 = i2.intValue();
            if(!i1.equals(i2)){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode slowNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = slowNext;

        }
        if (fast == null) {
            head = slow;
        } else {
            head = slow.next;
        }
        slow = prev;

        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(-149);
        ListNode b = new ListNode(-149);
        a.next = b;
        System.out.println(PandromeLinkedList.isPalindrome2(a));
    }
}
