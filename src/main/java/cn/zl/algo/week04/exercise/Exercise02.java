package cn.zl.algo.week04.exercise;

/**
 * 剑指Offer 10-2 青蛙跳台阶问题（简单）
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author liusha
 * @date 2021/12/20
 */
public class Exercise02 {


    int[] memo;
    public int numWays(int n) {
        if (n == 0) return 1;
        memo = new int[n + 1];
        return f(n);
    }

    private int f(int n) {
        if (n <= 2) return n;
        if (memo[n] != 0) return memo[n];
        int res = f(n - 1) + f(n - 2);
        res %= 1000000007;
        return memo[n] = res;
    }


    // dp
    public int numWays2(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        int f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f3 %= 1000000007;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }


}
