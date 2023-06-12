package two.week07.heap;

import java.util.*;

public class Exercise02Test2 {

    // 优于 O(n log n)
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
            set.add(num);
        }
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int num : set) {
            if (heap.size() < k) {
                heap.offer(num);
            } else {
                if (map.get(heap.peek()) < map.get(num)) {
                    heap.poll();
                    heap.offer(num);
                }
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
