package cn.zl.algo.week09.graph.exercise;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 08.10. 颜色填充（简单）
 *
 * @author liusha
 * @date 2022/2/17
 */
public class Exercise02 {

    // 方法1：BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) return image;
        int m = image.length, n = image[0].length;
        int originColor = image[sr][sc];
        if (originColor == newColor) return image;
        boolean[][] visited = new boolean[m][n];
        Queue<String> queue = new ArrayDeque<>();
        visited[sr][sc] = true;
        queue.offer(sr+ "_" + sc);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                String[] curArr = cur.split("_");
                int row = Integer.parseInt(curArr[0]);
                int col = Integer.parseInt(curArr[1]);
                image[row][col] = newColor;
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (isValid(image, visited, newRow, newCol, originColor)) {
                        visited[newRow][newCol] = true;
                        queue.offer(newRow + "_" + newCol);
                    }
                }
            }
        }
        return image;
    }

    //  =================  方法2 ： DFS

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) return image;
        int m = image.length, n = image[0].length;
        int originColor = image[sr][sc];
        if (originColor == newColor) return image;
        boolean[][] visited = new boolean[m][n];
        dfs(image, visited, sr, sc, originColor, newColor);
        return image;
    }

    private void dfs(int[][] image, boolean[][] visited, int row, int col, int originColor, int newColor) {
        visited[row][col] = true;
        image[row][col] = newColor;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValid(image, visited, newRow, newCol, originColor)) {
                dfs(image, visited, newRow, newCol, originColor, newColor);
            }
        }
    }

    private boolean isValid(int[][] image, boolean[][] visited, int i, int j, int originColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) return false;
        if (visited[i][j]) return false;
        if (image[i][j] != originColor) return false;
        return true;
    }
}
