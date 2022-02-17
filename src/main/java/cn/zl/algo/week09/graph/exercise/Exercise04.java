package cn.zl.algo.week09.graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200.岛屿数量（中等）（例题）
 *
 * // 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * // 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * // 此外，你可以假设该网格的四条边均被水包围。
 * //
 * //
 * // 示例 1：
 * // 输入：grid = [
 * //  ["1","1","1","1","0"],
 * //  ["1","1","0","1","0"],
 * //  ["1","1","0","0","0"],
 * //  ["0","0","0","0","0"]
 * //]
 * //输出：1
 * //
 * // 示例 2：
 * //输入：grid = [
 * //  ["1","1","0","0","0"],
 * //  ["1","1","0","0","0"],
 * //  ["0","0","1","0","0"],
 * //  ["0","0","0","1","1"]
 * //]
 * //输出：3
 * //
 * // 提示：
 * // m == grid.length
 * // n == grid[i].length
 * // 1 <= m, n <= 300
 * // grid[i][j] 的值为 '0' 或 '1'
 * @author liusha
 * @date 2022/2/17
 */
public class Exercise04 {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        // for循环找到1个等于1的节点，那么必定有岛屿
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // 把这个岛屿上的陆地部分都visited
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (isValid(grid, visited, newI, newJ)) {
                dfs(grid, visited, newI, newJ);
            }
        }
    }

    private boolean isValid(char[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (visited[i][j] || grid[i][j] == '0') return false;
        return true;
    }

    // ======================== 方法2 ： BFS ===========================

    public int numIslands2(char[][] grid) {
        // for循环找到1个等于1的节点，那么必定有岛屿
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // 把这个岛屿上的陆地部分都visited
                    count++;
                    // bfs
                    queue.offer(i + "_" + j);
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        String cur = queue.poll();
                        String[] curArr = cur.split("_");
                        int row = Integer.parseInt(curArr[0]);
                        int col = Integer.parseInt(curArr[1]);
                        for (int[] direction : directions) {
                            int newRow = row + direction[0];
                            int newCol = col + direction[1];
                            if (isValid(grid, visited, newRow, newCol)) {
                                queue.offer(newRow + "_" + newCol);
                                visited[newRow][newCol] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}
