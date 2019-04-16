package _56_删除链表中重复结点;

import Tools.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点。
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null || pHead.next==null)
            return pHead;

        ListNode pre = pHead;
        ListNode next = pHead;

        while (next!=null){
            int n = -1;
            int val = next.val;
            // 往后搜索所有和当前next相同的结点
            while (next!=null && next.val==val){
                n++;
                next = next.next;
            }

            // 有重复结点的情况
            if (n > 0){
                // 若头结点需要删除
                if (pHead.val == val){
                    pre = next;
                    pHead = next;
                }else {// 普通的删除
                    pre.next = next;
                }
            }else {// 无重复结点的情况
                // 本次循环不是判断的头结点，那pre和next一开始不相等，存在前后关系
                if (pHead.val != val){
                    pre = pre.next;
                }
                // 若这次循环判断的是头结点，则一开始pre==next，next往后移动之后，pre不需要移动
            }
        }

        return pHead;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        new Solution().deleteDuplication(x);
    }
}
