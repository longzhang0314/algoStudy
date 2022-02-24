package cn.zl.algo.week10.dp.exercise.type02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author liusha
 * @date 2022/2/23
 */
public class Exercise05 {

    public static void main(String[] args) {
        //   2
        //   3 4
        //   6 5 7
        //   4 1 8 3
        Exercise05 e = new Exercise05();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(e.minimumTotal(triangle)); // 11
    }


    // 方法2：一维dp
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                dp[j] = triangle.get(i).get(j) + Math.min(j < i ? dp[j] : Integer.MAX_VALUE, j - 1 >= 0 ? dp[j - 1] : Integer.MAX_VALUE);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[j]);
        }
        return min;
    }


    // 方法1：二维dp
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(j < i ? dp[i - 1][j] : Integer.MAX_VALUE, j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }

}
