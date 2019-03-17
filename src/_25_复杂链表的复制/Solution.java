package _25_复杂链表的复制;

import java.util.ArrayList;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution {
    /**
     * 思路：将输入的链表每个结点复制，并将复制后的结点插入复制前的结点之后
     * 然后将复制的结点的random指针赋值为原结点的random指针的next
     * 而后将该复合链表拆分为两个链表
     */
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode head = null;
        if (pHead == null)
            return head;

        // 遍历并复制结点
        RandomListNode p = pHead;
        while (p!=null){
            head = new RandomListNode(p.label);
            head.next = p.next;
            p.next = head;

            p = head.next;
        }

        // 将每个复制结点的random指针指向前一个结点的random指针的next
        p = pHead;
        while (p!=null){
            if (p.random!=null)
                p.next.random = p.random.next;
            p = p.next.next;
        }

        // 拆分链表
        head = pHead.next;
        p = pHead;
        RandomListNode q;
        while (p.next != null){
            q = p.next;
            p.next = q.next;
            p = q;
        }

        return head;
    }
}
