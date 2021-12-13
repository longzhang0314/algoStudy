package cn.zl.algo.week03.exercise;

/**
 * 面试题 03.01. 三合一（简单）
 *
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * @author: longzhang
 * @date: 2021/12/13
 */
public class Exercise05 {
}


class TripleInOne {

    private int[] arr;
    private int[] idx;
    private int n;

    public TripleInOne(int stackSize) {
        this.arr = new int[stackSize * 3];
        this.idx = new int[3];
        idx[0] = 0;
        idx[1] = stackSize;
        idx[2] = stackSize * 2;
        this.n = stackSize;
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) return;
        arr[idx[stackNum]] = value;
        ++idx[stackNum];
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        int pop = arr[idx[stackNum] - 1];
        --idx[stackNum];
        return pop;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        return arr[idx[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return idx[stackNum] == stackNum * n;
    }

    private boolean isFull(int stackNum) {
        return idx[stackNum] == (stackNum + 1) * n;
    }
}
