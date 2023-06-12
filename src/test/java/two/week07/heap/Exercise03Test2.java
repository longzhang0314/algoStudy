package two.week07.heap;

import java.util.PriorityQueue;

public class Exercise03Test2 {
    // 小顶堆数据都大于大顶堆；取中位数只需通过小顶堆和大顶堆堆顶元素判断即可
    // 记录总的数据条数
    // 放入数据时逻辑较多，取的时候只需要判断总条数奇数偶数即可

    class MedianFinder {

        private int size;
        // 小顶堆，存储较大元素
        private PriorityQueue<Integer> minHeap;
        // 大顶堆，存储较小元素
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            this.minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
            this.maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            this.size = 0;
        }

        public void addNum(int num) {
            boolean odd = (size & 1) == 1;
            if (odd) {
                // 如果为奇数，一定是大顶堆多一个
                // 取大顶堆当前堆顶与num的较大值放入minHeap，小顶堆数量+1，保持大顶堆数量不变
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            } else {
                // 如果为偶数，那么取小顶堆堆顶与num的较小值放入maxHeap，大顶堆数量+1，小顶堆数量不变
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }
            size++;
        }

        public double findMedian() {
            if (maxHeap.isEmpty()) return -1.0;
            boolean odd = (size & 1) == 1;
            if (odd) return maxHeap.peek();
            double v = ((double) maxHeap.peek() + minHeap.peek()) / 2;
            return v;
        }
    }
}
