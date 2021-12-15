package cn.zl.algo.week03.exercise;

/**
 * @author liusha
 * @date 2021/12/15
 */
public class Exercise05Test {
}

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 */
class TripleInOne {

    private int[] arr;

    // 每个数组的长度
    private int n;

    private int[] idx;

    public TripleInOne(int stackSize) {
        this.arr = new int[stackSize * 3];
        this.n = stackSize;
        this.idx = new int[3];
        idx[0] = 0;
        idx[1] = stackSize;
        idx[2] = stackSize * 2;
    }

    public void push(int stackNum, int val) {
        if (isFull(stackNum)) return;
        arr[idx[stackNum]++] = val;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        return arr[--idx[stackNum]];
    }

    public boolean isEmpty(int stackNum) {
        return idx[stackNum] == stackNum * n;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) return -1;
        int peek = arr[idx[stackNum] - 1];
        --idx[stackNum];
        return peek;
    }

    private boolean isFull(int stackNum) {
        return idx[stackNum] == (stackNum + 1) * n;
    }

}
