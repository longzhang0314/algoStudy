package cn.zl.algo.week09.graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13 机器人的运动范围(中等)（例题）
 *
 * //地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
 * //格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
 * //它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * // 示例 1：
 * // 输入：m = 2, n = 3, k = 1
 * // 输出：3
 * //
 * // 示例 2：
 * // 输入：m = 3, n = 1, k = 0
 * // 输出：1
 * //
 * // 提示：
 * // 1 <= n,m <= 100
 * // 0 <= k <= 20
 *
 *
 * @author liusha
 * @date 2022/2/17
 */
public class Exercise01 {
    // bfs
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<String> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(0 + "_" + 0);
        int count = 1;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            String[] curArr = cur.split("_");
            int row = Integer.parseInt(curArr[0]);
            int col = Integer.parseInt(curArr[1]);
            for (int[] direction : directions) {
                if (isValid(row, col, direction, visited, m, n, k)) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    visited[newRow][newCol] = true;
                    queue.offer(newRow + "_" + newCol);
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValid(int row, int col, int[] direction, boolean[][] visited, int m, int n, int k) {
        int newRow = row + direction[0];
        int newCol = col + direction[1];
        if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) return false;
        if (visited[newRow][newCol]) return false;
        if (newRow / 10 + newRow % 10 + newCol / 10 + newCol % 10 > k) return false;
        return true;
    }

    // dfs
    int count2;
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        dfs(m, n, k, visited, 0, 0);
        return count2;
    }

    private void dfs(int m, int n, int k, boolean[][] visited, int row, int col) {
        count2++;
        for (int[] direction : directions) {
            if (isValid(row, col, direction, visited, m, n, k)) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                visited[newRow][newCol] = true;
                dfs(m, n, k, visited, newRow, newCol);
            }
        }
    }
}
