package cn.zl.algo.week03.common;

/**
 * 基于数组实现栈
 * @author: longzhang
 * @date: 2021/12/12
 */
public class ArrayStack {
    private int[] arr;
    private int n;
    private int count;

    public ArrayStack(int n) {
        this.arr = new int[n];
        this.n = n;
    }

    public boolean push(int num) {
        if (count == n) {
            return false;
        }
        arr[count++] = num;
        return true;
    }

    public int pop() {
        if (isEmpty()) return -1;
        return arr[--count];
    }

    public int peek() {
        if (isEmpty()) return -1;
        return arr[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

}
