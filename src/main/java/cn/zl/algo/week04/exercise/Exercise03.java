package cn.zl.algo.week04.exercise;

/**
 * 面试题 08.01 三步问题（简单）
 *
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * @author liusha
 * @date 2021/12/20
 */
public class Exercise03 {

    int[] memo;
    public int waysToStep(int n) {
        if (n == 0) return 1;
        memo = new int[n + 1];
        return f(n);
    }

    private int f(int n) {
        if (n <= 2) return n;
        if (n == 3) return 4;
        if (memo[n] != 0) return memo[n];
        int res = (f(n - 1) + f(n - 2)) % 1000000007 + f(n - 3);
        res %= 1000000007;
        return memo[n] = res;
    }

    // dp
    public int waysToStep2(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        if (n == 3) return 4;
        int f1 = 1, f2 = 2, f3 = 4;
        for (int i = 4; i <= n; i++) {
            int f4 = (f1 + f2) % 1000000007 + f3;
            f4 %= 1000000007;
            f1 = f2;
            f2 = f3;
            f3 = f4;
        }
        return f3;
    }
}
