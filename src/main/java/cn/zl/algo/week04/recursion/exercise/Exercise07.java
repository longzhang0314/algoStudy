package cn.zl.algo.week04.recursion.exercise;

/**
 * 剑指Offer 16（中等）
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * @author liusha
 * @date 2021/12/20
 */
public class Exercise07 {

    public static void main(String[] args) {
        Exercise07 e = new Exercise07();
        System.out.println(e.myPow(2, 5));
        System.out.println(e.myPow(2, 10));
    }


    // 递归
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == Integer.MIN_VALUE) return 1 / myPow(x, Integer.MAX_VALUE) / x;
        if (n < 0) return 1 / myPow(x, -n);

        return (n & 1) == 1 ? x * myPow(x * x, n / 2) : myPow(x * x, n / 2);
    }


    // 非递归
    public double myPow2(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) return 1 / myPow2(x, Integer.MAX_VALUE) / x;
        if (n < 0) return 1 / myPow2(x, -n);
        double multi = 1;
        while (n != 1) {
            if ((n & 1) == 1) {
                multi *= x;
            }
            x *= x;
            n /= 2;
        }
        x *= multi;
        return x;
    }
}
