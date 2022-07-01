package two.week03;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 分三块/交替分
 *
 * @author liusha
 * @date 2022/6/6
 */
public class Exercise05Test {


    class TripleInOne {

        private int[] arr;
        private int n;
        private int[] idx;

        public TripleInOne(int stackSize) {
            this.arr = new int[stackSize * 3];
            this.n = stackSize * 3;
            this.idx = new int[3];
            int x = 3;
            for (int i = 0; i < x; i++) {
                idx[i] = -x + i;
            }
        }

        public void push(int stackNum, int value) {
            if (isFull(stackNum)) return;
            idx[stackNum] += 3;
            arr[idx[stackNum]] = value;
        }

        public int pop(int stackNum) {
            if (isEmpty(stackNum)) return -1;
            int res = arr[idx[stackNum]];
            idx[stackNum] -= 3;
            return res;
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

}
