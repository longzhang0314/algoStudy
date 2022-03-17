package cn.zl.algo.week10.dp.find;

/**
 * 123.
 * TODO do late
 * @author liusha
 * @date 2022/3/14
 */
public class Find09 {

    public static void main(String[] args) {
        Find09 f = new Find09();
        int[] prices = {1,2,3,4,5};
        System.out.println(f.maxProfit(prices)); // 4
    }


    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 只能交易2次 -》 操作数小于等于4
        int[][][] dp = new int[n][2][5];
        // dp[i][0][0] = 0 未持有，共操作0次
        // dp[i][0][1] = min  未持有，共操作1次（不可能）
        // dp[i][0][2] = Math.max(dp[i-1][0][2], dp[i-1][1][1] + prices[i])  未持有，共操作2次
        // dp[i][0][3] = min  未持有，共操作3次（不可能）
        // dp[i][0][4] = Math.max(dp[i-1][0][4], dp[i-1][1][3] + prices[i])  未持有，共操作4次

        // dp[i][1][0] = min 持有，共操作0次（不可能）
        // dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]) 持有，共操作1次
        // dp[i][1][2] = min 持有，共操作2次（不可能）
        // dp[i][1][3] = Math.max(dp[i-1][1][3], dp[i-1][0][2] - prices[i]) 持有，共操作2次
        // dp[i][1][4] = min 持有，共操作4次（不可能）

        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = j == 0 && k == 0 ? 0 : Integer.MIN_VALUE;
                }
            }
        }
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] != Integer.MIN_VALUE
                    ? dp[i - 1][1][1] + prices[i] : Integer.MIN_VALUE);
            dp[i][0][4] = Math.max(dp[i - 1][0][4], dp[i - 1][1][3] != Integer.MIN_VALUE
                    ? dp[i - 1][1][3] + prices[i] : Integer.MIN_VALUE);

            dp[i][1][1] = Math.max(dp[i - 1][1][1], - prices[i]);
            dp[i][1][3] = Math.max(dp[i - 1][1][3], dp[i - 1][0][2] != Integer.MIN_VALUE
                    ? dp[i - 1][0][2] - prices[i] : Integer.MIN_VALUE);
        }

        return max2(0, dp[n - 1][0][2], dp[n - 1][0][4], dp[n - 1][1][1], dp[n - 1][1][3]);
    }

    private int max2(int a, int b, int c, int d, int e) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        if (e > max) max = e;
        return max;
    }
}
