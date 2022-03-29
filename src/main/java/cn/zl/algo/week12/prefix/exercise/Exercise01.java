package cn.zl.algo.week12.prefix.exercise;

/**
 * 121.买卖股票的最佳时机
 *
 * @author liusha
 * @date 2022/3/29
 */
public class Exercise01 {


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        // 后缀最大，不包括自己
        int[] max = new int[n];
        max[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], prices[i + 1]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, max[i] - prices[i]);
        }
        return res;
    }

}
