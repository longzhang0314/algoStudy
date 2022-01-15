package cn.zl.algo.week07.heap.exercise;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数（困难）（已讲）
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise03 {

    class MedianFinder {

        // 小顶堆
        PriorityQueue<Integer> min;
        // 大顶堆 多存一个
        PriorityQueue<Integer> max;

        public MedianFinder() {
            this.min = new PriorityQueue<>((a, b) -> a - b);
            this.max = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            // 先存大顶堆，然后堆顶放到小顶堆，再放回大顶堆
            max.offer(num);
            min.offer(max.poll());
            if (min.size() > max.size()) {
                max.offer(min.poll());
            }
        }

        public double findMedian() {
            if ((min.size() + max.size()) % 2 == 1) {
                return max.peek();
            } else {
                return (double) (min.peek() + max.peek()) / 2;
            }
        }
    }

}
