package _14_查链表节点;

import Tools.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution {
    // 常规思路：
    // 先遍历求长度n，然后再找第n-k个节点
    public ListNode FindKthToTail(ListNode head, int k) {
        int n = 0;
        ListNode p = head;

        while (p!=null){
            n++;
            p = p.next;
        }

        if (k<=n)
            for (int i = k;i < n;i++)
                head = head.next;
        else
            return null;

        return head;
    }

//    // 优解思路：
//    // 两个指针，一个指针移动到第k个节点
//    // 然后两个指针一起后移，到第一个指针到链表尾部时，第二个指针即倒数第k个节点
//    // 注：该方法难以保证倒数第k个节点存在，会报空指针异常
//    public ListNode FindKthToTail(ListNode head,int k) {
//        ListNode p = head;
//
//        for (int i = 0;i < k;i++)
//            p = p.next;
//
//        while (p!=null){
//            p = p.next;
//            head = head.next;
//        }
//
//        return head;
//    }
}
