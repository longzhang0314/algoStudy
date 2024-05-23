package two.week12.prefix;

/**
 * @author 流沙
 * @date 2024/4/9
 */
public class Exercise01Test2 {

    // 121:prefix：买卖一次
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        // 当前位置之后的最大值，本质是暴力法替换，则访问到当前位置时无需向后遍历
        int[] max = new int[n];
        int curMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            max[i] = curMax;
            curMax = Math.max(curMax, prices[i]);
        }
        // 正常遍历，内层for的暴力由后缀最大的max替代
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, max[i] - prices[i]);
        }
        return res;
    }
}
