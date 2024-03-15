package two.week11.exercise.type01;

/**
 * @author 流沙
 * @date 2024/3/12
 */
public class Exercise04Test2 {

    public static void main(String[] args) {
        Exercise04Test2 e = new Exercise04Test2();
        System.out.println(e.cuttingBamboo(12));
    }

    // LCR 131. 砍竹子 I
    // 现需要将一根长为正整数 bamboo_len 的竹子砍为若干段，每段长度均为正整数。请返回每段竹子长度的最大乘积是多少。

    // 示例 1：
    //
    //输入: bamboo_len = 12
    //输出: 81
    //提示：
    //2 <= bamboo_len <= 58
    public int cuttingBamboo(int bamboo_len) {
        // 最少拆分为：2节
        // 最多拆分为：bamboo_len节
        // 重复子问题：拆分过的总值 * 待拆分模块计算结果
        if (bamboo_len == 2) return 1;
        if (bamboo_len == 3) return 2;
        // 其余大于3的，总长度一定>=bamboo_len
        int model = 1;
        // 长度为i的最大乘积
        int[] dp = new int[bamboo_len + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= bamboo_len; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));
            }
        }
        return dp[bamboo_len];
    }

}
