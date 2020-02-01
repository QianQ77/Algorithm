package main.java.leetCode;

import main.java.util.ListNode;

/**
 * Created by qiuqian on 8/13/17.
 */
public class RemoveLinkedListDuplicates {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        while(start.next != null){
            if(start.next.val == val){
                start.next = start.next.next;

            }
            start = start.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = new ListNode(6);
        head.next = node;

        ListNode result = RemoveLinkedListDuplicates.removeElements(head, 6);
        System.out.println(result.val);
    }
}
