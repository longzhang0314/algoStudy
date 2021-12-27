package cn.zl.algo.week05.binary.exercise;

/**
 * 367. 有效的完全平方数（简单）
 *
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 * 输入：num = 16
 * 输出：true
 *
 * @author liusha
 * @date 2021/12/27
 */
public class Exercise11 {


    public boolean isPerfectSquare(int num) {
        int left = 0, right = num / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long mid22 = (long) mid * mid;
            if (mid22 == num) {
                return true;
            } else if (mid22 < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
