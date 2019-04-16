package _36_链表的首个公共结点;

import Tools.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Solution {
    /**
     * 思路：
     * 用两个指针p1和p2分别指向 链表1 和 链表2 ，设链表1的长度为n，链表2的长度为m
     * 则使p1从 表1->表2，使p2从 表2->表1，则两个指针走的长度都为 m+n，必然在此之前相遇。
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1,p2 = pHead2;

        while (p1!=p2){
            p1 = p1==null?pHead2:p1.next;
            p2 = p2==null?pHead1:p2.next;
        }

        return p1;
    }
}
