package cn.zl.algo.week05.binary.example;

/**
 * 例题6. 二分答案  69.x的平方根
 *
 * 实现int sqrt(x)函数
 * 计算并返回x的平方根，其中x是非负整数
 *
 * 返回类型整数，只保留整数部分，小数部分被舍弃
 * @author: longzhang
 * @date: 2021/12/26
 */
public class Example06 {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 0, right = x / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long mid22 = (long) mid * mid;
            if (mid22 == x) {
                return mid;
            } else if (mid22 < x && ((long) mid + 1) * (mid + 1) > x) {
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
