package _16_合并排序链表;

import Tools.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */


public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head=null,current=null;

        if (list1==null)
            return list2;
        if (list2==null)
            return list1;

        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                if (current==null) {
                    current = list1;
                    head = current;
                    list1 = list1.next;
                }
                else {
                    current.next = list1;
                    list1 = list1.next;
                    current = current.next;
                }
            }else {
                if (current==null) {
                    current = list2;
                    head = current;
                    list2 = list2.next;
                }
                else {
                    current.next = list2;
                    list2 = list2.next;
                    current = current.next;
                }
            }
        }

        if (list1==null)
            current.next = list2;
        if (list2==null)
            current.next=list1;

        return head;
    }
}
