package cn.zl.algo.week05.binary.exercise;

/**
 * 69. x的平方根（简单）
 * 二分答案
 *
 * 向下取整
 *
 * @author liusha
 * @date 2021/12/28
 */
public class Exercise12 {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long mid22 = (long) mid * mid;
            if (mid22 == x) {
                return mid;
            } else if (mid22 < x && (long) (mid + 1) * (mid + 1) > x) {
                return mid;
            } else if (mid22 < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
