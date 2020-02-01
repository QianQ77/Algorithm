package leetCode;

import main.java.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum1 = l1.val + l2.val;
        int add = 0;
        ListNode l3;
        if(sum1 > 9){
            l3 = new ListNode(sum1 % 10);
            add = 1;
        }else{
            add = 0;
            l3 = new ListNode(sum1);
        }
        ListNode current = l3;

        ListNode current1 = l1;
        ListNode current2 = l2;
        while(current1.next !=null || current2.next !=null){
            int sum;

            if(current1.next == null){
                sum = current2.next.val+add;
                current2 = current2.next;
            }else if(current2.next == null){
                sum = current1.next.val+add;
                current1 = current1.next;
            }else{
                sum = current1.next.val + current2.next.val + add;
                current1= current1.next;
                current2= current2.next;

            }

            if(sum > 9){
                current.next = new ListNode(sum % 10);
                add = 1;
            }else{
                add = 0;
                current.next = new ListNode(sum);
            }
            current = current.next;
        }
        /*!!!*/
        if(add !=0){
            current.next = new ListNode(1);
        }
        return l3;
    }
/*
Note that we use a dummy head to simplify the code.
Without a dummy head, you would have to write extra conditional statements to initialize the head's value.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }*/
}
