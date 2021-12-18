package cn.zl.algo.week03.exercise;

/**
 * 面试题 03.01. 三合一（简单）
 *
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 【注意】（两种：分3块或者交替分）
 *
 * TODO 变形题：一共n个空间，3个栈不限制每个栈的大小
 *
 * @author: longzhang
 * @date: 2021/12/13
 */
public class Exercise05 {
}

// 方法1：数组分成3块空间，独立变化
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

// 方法2：交替使用数组空间
class TripleInOne2 {

    private int[] arr;
    private int[] idx;
    private int n;

    public TripleInOne2(int stackSize) {
        this.arr = new int[stackSize * 3];
        this.idx = new int[3];
        idx[0] = -3;
        idx[1] = -2;
        idx[2] = -1;
        this.n = stackSize * 3;
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) return;
        idx[stackNum] += 3;
        arr[idx[stackNum]] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        int pop = arr[idx[stackNum]];
        idx[stackNum] -= 3;
        return pop;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        return arr[idx[stackNum]];
    }

    public boolean isEmpty(int stackNum) {
        return idx[stackNum] < 0;
    }

    private boolean isFull(int stackNum) {
        return idx[stackNum] + 3 >= n;
    }
}
