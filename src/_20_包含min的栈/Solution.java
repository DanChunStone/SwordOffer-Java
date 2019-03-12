package _20_包含min的栈;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

import java.util.Stack;
public class Solution {
    Stack<Integer> stack;
    int min_index = 0;

    public void push(int node) {
        stack.push(node);
        if (stack.get(min_index)>node)
            min_index = stack.size()-1;
    }

    public void pop() {

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return 1;
    }
}
