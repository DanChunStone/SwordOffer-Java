package _15_链表反转;

import Tools.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode p = head;

        if (head==null)
            return null;

        p = p.next;
        head.next = null;
        while (p!=null){
            ListNode q = p.next;
            p.next = head;
            head = p;
            p = q;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
