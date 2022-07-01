package two.week03;

import java.util.Stack;

/**
 * @author liusha
 * @date 2022/5/31
 */
public class Exercise01Test2 {

    // 出栈时全部到tmp
    class CQueue {

        private Stack<Integer> stack;
        private Stack<Integer> tmp;

        public CQueue() {
            this.stack = new Stack<>();
            this.tmp = new Stack<>();
        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            if (!tmp.isEmpty()) return tmp.pop();
            while (!stack.isEmpty()) {
                tmp.push(stack.pop());
            }
            return tmp.pop();
        }
    }
}
