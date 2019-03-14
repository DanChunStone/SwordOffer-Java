package _20_包含min的栈;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
/**
 * 思路：
 * 定义一个栈用于存储数据，另一个辅助站用于存储：（当前位置元素位于栈顶时，栈内最小的元素）
 * 即：[2 2 3 2 1 3] -> [2 2 2 2 1 1]
 */

import java.util.Stack;
public class Solution {
    Stack<Integer> stack1 = new Stack<>(); // 元素栈
    Stack<Integer> stack2 = new Stack<>(); // 辅助栈
    int min; // 当前最小值

    // push操作：
    // 先向元素栈正常入栈
    // 然后判断，push的元素是否大于当前最小值
    // 若大于，则辅助栈push一次最小值min（因为当该node位于栈顶时，最小值仍为当前min）
    // 若小于，则辅助栈push一次node，并将min的值改为node
    public void push(int node) {
        if (stack1.empty()){
            stack2.push(node);
            min = node;
        }else {
            if (node>=min){
                stack2.push(min);
            }else {
                stack2.push(node);
                min = node;
            }
        }
        stack1.push(node);
    }

    // pop操作时，两个栈都出栈一次
    // 并将min改为辅助栈栈顶元素的值
    public void pop() {
        if (!stack1.empty()){
            stack1.pop();
            stack2.pop();
            min=stack2.peek();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return min;
    }
}
