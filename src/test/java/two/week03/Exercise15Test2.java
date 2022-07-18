package two.week03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liusha
 * @date 2022/7/18
 */
public class Exercise15Test2 {


    // TODO 待验证
    class MaxQueue {

        private Queue<Integer> queue;
        // 头部最大，单调非递增，例如 4 3 1 2 2，那么存4 3 2 2；出队时与deque对比，完全相同就出
        private Deque<Integer> deque;

        public MaxQueue() {
            this.queue = new LinkedList<>();
            this.deque = new LinkedList<>();
        }

        public int max_value() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.offerLast(value);

        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int val = queue.poll();
            if (deque.peekFirst() == val) {
                deque.pollFirst();
            }
            return val;
        }

    }
}
