package cn.zl.algo.week01.iq.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵（中等）经典
 */
public class Exercise09 {


    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        if (n == 0) return new ArrayList<>();
        // 按照directions[i++]的方向螺旋遍历
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> res = new ArrayList<>();
        // 变向条件：1.遇到边界：i >= m || j >= n || i < 0 || j < 0;
        // 2. 遇到遍历过的元素 3.最后一个元素直接结束
        boolean[][] visited = new boolean[m][n];
        int cnt = m * n;
        int i = 0, j = 0;
        int dIdx = 0;
        while (cnt > 0) {
            res.add(matrix[i][j]);
            visited[i][j] = true;
            cnt--;
            int[] direction = directions[dIdx];
            // 接下来是否可以继续按这个方向走
            if (!canRun(m, n, visited, i + direction[0], j + direction[1])) {
                dIdx = (dIdx + 1) % 4;
                direction = directions[dIdx];
            }
            i = i + direction[0];
            j = j + direction[1];
        }
        return res;
    }

    private boolean canRun(int m, int n, boolean[][] visited, int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n && !visited[i][j];
    }
}
