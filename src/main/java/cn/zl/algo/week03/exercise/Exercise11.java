package cn.zl.algo.week03.exercise;

import java.util.Stack;

/**
 * 739. 每日温度（中等） 单调栈 （已讲）
 *
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * @author: longzhang
 * @date: 2021/12/14
 */
public class Exercise11 {

    // 方法1：暴力法
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];
        int[] res = new int[temperatures.length];
        // 存储索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }
}
