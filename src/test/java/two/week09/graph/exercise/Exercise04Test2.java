package two.week09.graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 流沙
 * @date 2023/9/13
 */
public class Exercise04Test2 {


    //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    //
    // 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
    //
    // 此外，你可以假设该网格的四条边均被水包围。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：grid = [
    //  ["1","1","1","1","0"],
    //  ["1","1","0","1","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","0","0","0"]
    //]
    //输出：1
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    // dfs时仅向右向下即可
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if (!valid(grid, visited, i, j, m, n)) {
            return;
        }
        visited[i][j] = true;
        for (int[] direction : directions) {
            dfs(grid, visited, i + direction[0], j + direction[1], m, n);
        }
    }

    private boolean valid(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n && !visited[i][j] && grid[i][j] == '1';
    }


    // ========== BFS

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    // bfs的目的是将相邻的陆地部分全部标位visited
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int[] direction : directions) {
                            int newI = cur[0] + direction[0];
                            int newJ = cur[1] + direction[1];
                            if (valid(grid, visited, newI, newJ, m, n)) {
                                queue.offer(new int[]{newI, newJ});
                                visited[newI][newJ] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
