package _55_链表中环的入口;

import Tools.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Solution {
    /**
     * 思路：
     * 使用快慢指针：p1一次走一步，p2一次走两步
     * 设链表头到环入口结点的距离为m，环的长度为n
     * 则当p1和p2第一次相遇时，p1走过了m+x，p2走过了m+n+x，且p2长度是p1的两倍
     * 说明，m+x = n，即非环长度 + p1走过入口的距离，等于环的长度。换言之，p1现在离入口的距离，等于头结点到入口的距离
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null || pHead.next==null)
            return null;

        ListNode p1 = pHead,p2 = pHead;

        while (p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2){
                p2 = pHead;
                while (p1!=p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }

        return null;
    }


    // 常规思路：将链表中的结点按顺序放入链表中，一旦遇到重复结点，则为入口结点
//    public ListNode EntryNodeOfLoop(ListNode pHead) {
//        if (pHead==null)
//            return null;
//
//        List<ListNode> listNodes = new LinkedList<>();
//
//        while (pHead!=null){
//            if (listNodes.contains(pHead))
//                return pHead;
//            listNodes.add(pHead);
//
//            pHead = pHead.next;
//        }
//
//        return null;
//    }
}
