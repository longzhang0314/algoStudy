package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * @author liusha
 * @date 2021/12/15
 */
public class Exercise03Test {
}

// 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
// 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
// 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

class SortedStack {

    private Stack<Integer> stack;
    private Stack<Integer> tmp;

    public SortedStack() {
        this.stack = new Stack<>();
        this.tmp = new Stack<>();
    }

    // 出栈捣腾
    public void push(int val) {
        while (!stack.isEmpty() && stack.peek() > val) {
            tmp.push(stack.pop());
        }
        stack.push(val);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    public int pop() {
        if (isEmpty()) return -1;
        return stack.pop();
    }

    public int peek() {
        if (isEmpty()) return -1;
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

