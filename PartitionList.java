package main.java.leetCode;

import main.java.util.ListNode;

/**
 * Created by qiuqian on 7/22/17.
 */
public class PartitionList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode partition(ListNode head, int x) {
            if(head == null || head.next == null){
                return head;
            }

            ListNode prevNode = new ListNode(0);
            prevNode.next = head;
            ListNode prev = prevNode;

            while(head.next != null && head.val < x){
                prev = head;
                head = head.next;
            }

            if(head.next == null){
                return prevNode.next;
            }

            ListNode greaterOrEqualX = head;
            ListNode preGreaterOrEqualX = prev;

            while(head != null){
                if(head.val >= x){
                    prev = head;
                    head = head.next;
                }else{
                    ListNode post = head.next;
                    head.next = greaterOrEqualX;
                    preGreaterOrEqualX.next = head;
                    preGreaterOrEqualX = head; //important
                    prev.next = post;
                    head = post;
                }
            }

            return prevNode.next;

        }
    }
}
