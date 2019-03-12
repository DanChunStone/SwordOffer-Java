package _3_转换链表;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

