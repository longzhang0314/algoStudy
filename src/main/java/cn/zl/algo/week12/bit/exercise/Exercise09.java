package cn.zl.algo.week12.bit.exercise;

/**
 * 面试题 16.01. 交换数字
 *
 * @author: longzhang
 * @date: 2022/4/5
 */
public class Exercise09 {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
