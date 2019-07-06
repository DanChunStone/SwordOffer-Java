package _63_数据流的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution {
    // 大顶堆，用于存储数据流中前半部分（较小），堆顶为前半部分中的最大值
    private PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    // 小顶堆，用于存储数据流中后半部分（较大），堆顶为后半部分中的最小值
    private PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });

    // 记录下一个元素需要放到那一部分，若为true，也表示两个堆中的元素个数相等
    private boolean isMax = true;

    public void Insert(Integer num) {
        // 新元素需要放到前半部分
        if (isMax){
            // 若新整数大于后半部分的最小值，新数应该进入后半部分，后半部分的最小值进入前半部分
            if (min.size() != 0 && num > min.peek()){
                max.add(min.poll());
                min.add(num);
            }else {
                max.add(num);
            }
        }else { // 新元素需要放到后半部分
            // 若新整数小于前半部分的最大值，新数应该进入前半部分，前半部分的最大值进入后半部分
            if (max.size() != 0 && num < max.peek()){
                min.add(max.poll());
                max.add(num);
            }else {
                min.add(num);
            }
        }

        isMax = !isMax;
    }

    public Double GetMedian() {
        if (max.size() == 0 && min.size() == 0)
            return null;

        if (isMax){
            return (double) (max.peek() + min.peek()) / 2;
        }else {
            if (max.size()>min.size())
                return (double) max.peek();
            else
                return (double) min.peek();
        }
    }
}
