package cn.zl.algo;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * TODO 双周赛+周赛题目 5947、5948、5959、5965、5966，复习上周周赛困难题 2111
 *
 * @author: longzhang
 * @date: 2021/12/19
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();
//        int[] apples = {1,2,3,5,2};
//        int[] apples = {3,0,0,0,0,2};
//        int[] apples = {20000};
         //31
//        int[] days = {3,2,1,4,2};
//        int[] days = {3,0,0,0,0,2};
//        int[] days = {20000};
        int[] apples = {9,10,1,7,0,2,1,4,1,7,0,11,0,11,0,0,9,11,11,2,0,5,5};
        int[] days = {3,19,1,14,0,4,1,8,2,7,0,13,0,13,0,0,2,2,13,1,0,3,7};

        System.out.println(t.eatenApples(apples, days));
    }


    // 方法1：贪心+堆
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        // 0 数量  1 保质期
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!heap.isEmpty() && heap.peek()[1] <= i) {
                heap.poll();
            }
            int day = i + days[i];
            if (apples[i] != 0) {
                heap.offer(new int[]{apples[i], day});
            }
            if (!heap.isEmpty()) {
                int[] top = heap.peek();
                ans++;
                if (top[0] <= 1) {
                    heap.poll();
                } else {
                    heap.peek()[0]--;
                }
            }
        }
        if (heap.isEmpty()) return ans;
        int i = n;
        while (!heap.isEmpty()) {
            if (heap.peek()[1] <= i) {
                heap.poll();
                continue;
            }
            int[] top = heap.peek();
            ans++;
            if (top[0] <= 1) {
                heap.poll();
            } else {
                heap.peek()[0]--;
            }
            i++;
        }
        return ans;
    }

    public int eatenApples2(int[] apples, int[] days) {
        int n = apples.length;
        int ans = 0;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i = 0;i < n;i++) {
            // 这一天已经过期了
            int day = days[i] + i;
            if(apples[i] != 0) {
                tm.put(day,tm.getOrDefault(day,0) + apples[i]);
            }
            // 所以这里是不能取的，必须大于
            Map.Entry<Integer,Integer> higher = tm.higherEntry(i);
            if(higher != null) {
                ans++;
                if(higher.getValue() <= 1) {
                    tm.remove(higher.getKey());
                } else {
                    tm.put(higher.getKey(),higher.getValue() - 1);
                }
            }
        }
        if(tm.isEmpty()) {
            return ans;
        }
        int limit = tm.lastKey();
        for(int i = n;i <= limit;i++) {
            Map.Entry<Integer,Integer> higher = tm.higherEntry(i);
            if(higher != null) {
                ans++;
                if(higher.getValue() <= 1) {
                    tm.remove(higher.getKey());
                } else {
                    tm.put(higher.getKey(),higher.getValue() - 1);
                }
            }
        }
        return ans;
    }


}
