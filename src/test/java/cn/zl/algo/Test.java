package cn.zl.algo;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
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


    public int eatenApples(int[] apples, int[] days) {
        if (apples == null || apples.length == 0) return 0;
        int n = days.length;
        // int[0] 苹果个数  int[1] 腐烂日期（第几个索引时腐烂）
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int eat = 0;
        int i = 0;
        for (; i < n; i++) {
            // 腐烂日期小于等于i或者吃完的都出队
            while (!heap.isEmpty() && (heap.peek()[1] <= i || heap.peek()[0] <= 0)) {
                heap.poll();
            }
            if (days[i] > 0 && apples[i] > 0) {
                heap.offer(new int[]{apples[i], i + days[i]});
            }

            if (!heap.isEmpty()) {
                eat++;
                heap.peek()[0]--;
            }
        }

        // 不再新增苹果
        while (!heap.isEmpty()) {
            // 过期的先出去
            if (heap.peek()[1] <= i || heap.peek()[0] <= 0) {
                heap.poll();
                continue;
            }
            int[] peek = heap.peek();
            eat += Math.min(peek[1] - i, peek[0]);
            heap.poll();
            i++;
        }
        return eat;
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
