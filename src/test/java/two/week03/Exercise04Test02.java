package two.week03;

import java.util.Stack;

/**
 * @author liusha
 * @date 2022/6/6
 */
public class Exercise04Test02 {

    class MinStack {

        private Stack<Integer> stack;

        public MinStack() {
            this.stack = new Stack<>();
        }

        public void push(int val) {
            int min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            stack.push(val);
            stack.push(Math.min(min, val));
        }

        public void pop() {
            if (stack.isEmpty()) return;
            stack.pop();
            stack.pop();
        }

        public int top() {
            if (stack.isEmpty()) return -1;
            int val = stack.pop();
            int res = stack.peek();
            stack.push(val);
            return res;
        }

        public int getMin() {
            if (stack.isEmpty()) return -1;
            return stack.peek();
        }

    }

}
