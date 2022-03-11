package cn.zl.algo.week10.dp.find;

/**
 * 343. 整数拆分
 *
 * @author liusha
 * @date 2022/3/11
 */
public class Find05 {


    public static void main(String[] args) {
        Find05 f = new Find05();
        System.out.println(f.integerBreak(10)); // 36    3*3*4
    }


    public int integerBreak(int n) {
        // f(n) = max(f(i) * (n-i))，i -> [1,n-1]
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = max(dp[i], dp[j] * (i - j), j * (i - j));
            }
        }
        return dp[n];
    }

    private int max(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}
