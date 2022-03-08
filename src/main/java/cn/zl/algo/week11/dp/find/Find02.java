package cn.zl.algo.week11.dp.find;


/**
 * 174.地下城游戏
 *
 * @author liusha
 * @date 2022/3/2
 */
public class Find02 {


    public static void main(String[] args) {
        Find02 f = new Find02();
        int[][] dungeon = {{-2,-3,3}, {-5,-10,1}, {10,30,-5}};
        System.out.println(f.calculateMinimumHP(dungeon));
    }


    // [[-2,-3,3],
    //  [-5,-10,1],
    //  [10,30,-5]]
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;

        // 正向dp不满足无后效性，因为填表过程中，当前路径最小路径和、当前路径所需最小初始值两个参数重要性相同，无法向后推导

        // 从dp[i][j]到终点所需的最小值；dp[0][0]即为所求解
        int[][] dp = new int[m][n];
        // 从dp[i+1][j]和dp[i][j+1]推出dp[i][j]
        // 递推公式：dp[i][j] = max (min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j], 1)
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : Math.abs(dungeon[m - 1][n - 1]) + 1;
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

}
