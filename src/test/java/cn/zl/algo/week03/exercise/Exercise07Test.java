package cn.zl.algo.week03.exercise;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Stack;

/**
 *
 * 面试题 16.26. 计算器
 *
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 * @author liusha
 * @date 2021/12/15
 */
public class Exercise07Test {

    public int calc(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0, n = s.length();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        while (i < n) {

        }
        // TODO 没练完
        return -1;
    }

}
