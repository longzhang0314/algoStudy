package cn.zl.algo.week03.example;

import java.util.Stack;

/**
 * 单调栈 739.每日温度
 *
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * @author liusha
 * @date 2021/12/13
 */
public class Example04 {

    // 方法1：暴力法
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return new int[0];
        int[] res = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    // 方法2: 单调栈
    public int[] dailyTemperatures2(int[] T) {
        if (T == null || T.length == 0) return new int[0];
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }


}
