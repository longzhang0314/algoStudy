package cn.zl.algo.week04.exercise;

/**
 * 剑指Offer 10-1 斐波那契数列（简单）
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author liusha
 * @date 2021/12/20
 */
public class Exercise01 {

    int[] memo;
    public int fib(int n) {
        this.memo = new int[n + 1];
        return f(n);
    }

    private int f(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        int res = f(n - 1) + f(n - 2);
        res %= 1000000007;
        return memo[n] = res;
    }


    // dp
    public int fib2(int n) {
        if (n <= 1) return n;
        int f0 = 0, f1 = 1;
        for (int i = 2; i <= n; i++) {
            int f2 = f0 + f1;
            f2 %= 1000000007;
            f0 = f1;
            f1 = f2;
        }
        return f1;
    }

}
