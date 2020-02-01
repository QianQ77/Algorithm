package main.java.leetCode;

import main.java.util.ListNode;

import java.util.ArrayList;

/**
 * Created by qiuqian on 7/21/17.
 */


public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ArrayList<Integer> array = new ArrayList<Integer>();
        while(head.next != null){
            array.add(head.val);
            head = head.next;
        }

        ListNode result = head;

        for(int i = array.size()-1; i >=0 ; i--){
            ListNode node = new ListNode(array.get(i));
            head.next = node;
            head = node;
        }

        return result;
    }

    public static void main(String[] args){

    }
}