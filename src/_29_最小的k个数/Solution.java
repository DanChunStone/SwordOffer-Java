package _29_最小的k个数;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length <= 0 || k > input.length || k == 0)
            return result;

        // PriorityQueue保存队列元素的顺序并不是按加入队列的顺序，而是按队列元素的大小进行重新排序
        // 自定义comparator接口，使其中的元素从大到小排序
        PriorityQueue<Integer> minResult = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        // 遍历输入
        for (int i = 0;i < input.length;i++){
            // 若最大堆没有放满，继续放入元素
            if (i < k){
                minResult.offer(input[i]);
            }else {
                // 比较堆顶（最大元素）与当前元素大小
                // 若堆顶元素更大，则将其弹出，并将当前元素加入堆
                // 当前元素入堆后，自动按顺序排序
                if (minResult.peek() > input[i]){
                    minResult.poll();
                    minResult.offer(input[i]);
                }
            }
        }

        for (int x : minResult)
            result.add(x);

        return result;
    }
}
