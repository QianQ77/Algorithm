package main.java.leetCode;

import main.java.util.ListNode;

/**
 * Created by qiuqian on 8/27/18.
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) {
            node.next = l2;
        }else {
            node.next = l1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.fromArray(new int[]{1,4,6});
        ListNode l2 = ListNode.fromArray(new int[]{1,2,5});
        System.out.println(mergeTwoLists(l1, l2));
    }
}
