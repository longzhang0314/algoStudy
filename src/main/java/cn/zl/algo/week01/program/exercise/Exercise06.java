package cn.zl.algo.week01.program.exercise;

/**
 * TODO 补充题目信息
 */
public class Exercise06 {

    // 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    // 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
    // 输入：x = 121
    // 输出：true
    // 输入：x = -121
    // 输出：false
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        // 获取反转后的数字，和原数字对比
        // 防止超过int最大值
        long origin = x;
        long target = 0;
        while (x != 0) {
            int val = x % 10;
            target = target * 10 + val;
            x /= 10;
        }
        return origin == target;
    }
}
