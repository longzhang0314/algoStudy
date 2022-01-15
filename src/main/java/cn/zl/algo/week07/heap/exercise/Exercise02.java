package cn.zl.algo.week07.heap.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素（中等）（已讲）
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise02 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 前k个高频，按照频率构建容量为k的小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            if (heap.size() < k) {
                heap.offer(num);
            } else if (map.get(heap.peek()) < entry.getValue()) {
                heap.poll();
                heap.offer(num);
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            res[i++] = heap.poll();
        }
        return res;
    }
}
