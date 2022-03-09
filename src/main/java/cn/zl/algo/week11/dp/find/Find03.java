package cn.zl.algo.week11.dp.find;

/**
 * 96.不同的二叉搜索树
 *
 * TODO do 用两个递推公示数学运算转换成递推公示
 *
 * @author liusha
 * @date 2022/3/9
 */
public class Find03 {


    // 二叉搜索树：左子树 < 根节点 < 右子树
    public int numTrees(int n) {
        // 左子树i个，右字数n-i-1个 i:[0,n-1]
        // f(n) = sum (g(n, i)); f函数：n个节点能组成的二叉树种类个数；g函数：n个节点，以i为根能组成的二叉树种类个数
        // g(n,i) = f(i-1) * f(n-i)
        // 所以推出：f(n) = sum(f(i-1) * f(n-i))
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // i个数
        for (int i = 2; i <= n; i++) {
            // 以j为根
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
