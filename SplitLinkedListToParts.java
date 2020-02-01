package main.java.leetCode;

import main.java.util.ListNode;

/**
 * Created by qiuqian on 11/12/17.
 */
public class SplitLinkedListToParts {
    public static ListNode[] splitListToParts(ListNode root, int k) {

        int count = 0;
        ListNode current = root;
        while(current != null) {
            current = current.next;
            count++;
        }
        ListNode[] result = new ListNode[k];
        current = root;
        /*
        if(count < k) {
            int index = 0;
            while(current != null) {
                result[index] = new ListNode(current.val);
                index++;
                current = current.next;
            }
        }else {
        */
            int size = count / k;
            int remain = count % k;
            int index = 0;
            int i = 0;
            while(current != null) {
                if(i == 0) {
                    result[index] = new ListNode(current.val);

                }
                if((remain == 0 && i == size - 1) || (remain > 0  && i == size)) {
                    i = 0;
                    //Error point;
                    index++;
                    ListNode nextNode = current.next;
                    current.next = null;
                    current = nextNode;
                    if(remain > 0) {
                        remain--;
                    }
                }else {
                    if(i == 0) {
                        result[index].next = current.next;
                    }
                    current = current.next;
                    i++;
                }

            }
            /*
        }
        */
        return result;
    }

    public static void main(String[] args) {
        int k = 5;
        ListNode root = ListNode.fromArray(new int[]{1,2,3,4});
        ListNode[] result = SplitLinkedListToParts.splitListToParts(root, k);
        for(ListNode node: result) {
            System.out.println(node);
        }
    }
}
