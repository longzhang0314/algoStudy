package two.week03;

import java.util.Stack;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek返回 -1。
 * @author liusha
 * @date 2022/6/6
 */
public class Exercise03Test2 {

    class SortedStack {

        private Stack<Integer> stack;
        private Stack<Integer> tmp;

        public SortedStack() {
            this.stack = new Stack<>();
            this.tmp = new Stack<>();
        }

        public void push(int val) {
            while (!stack.isEmpty()) {
                if (stack.peek() >= val) break;
                tmp.push(stack.pop());
            }
            stack.push(val);
            while (!tmp.isEmpty()) {
                stack.push(tmp.pop());
            }
        }

        public void pop() {
            if (isEmpty()) return;
            stack.pop();
        }

        public int peek() {
            if (isEmpty()) return -1;
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

    }
}
