package two.week03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liusha
 * @date 2022/6/1
 */
public class Exercise02Test2 {

    class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            this.queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.offer(queue.poll());
            }
            return queue.poll();
        }

        public int top() {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.offer(queue.poll());
            }
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
