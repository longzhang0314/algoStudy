package two.week04.recursion;

/**
 * @author liusha
 * @date 2022/7/27
 */
public class Exercise07Test2 {

    // TODO 待验证 看下原题解
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) return 1 / myPow(x, Integer.MAX_VALUE) / x;
        if (n < 0) return 1 / myPow(x, -n);
        if (x == 1) return x;
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }


    // 非递归 TODO
    public double myPow2(double x, int n) {
        return -1;
    }
}
