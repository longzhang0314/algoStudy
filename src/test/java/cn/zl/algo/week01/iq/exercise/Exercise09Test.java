package cn.zl.algo.week01.iq.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise09Test {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int cnt = m * n;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int idx = 0;
        boolean[][] visited = new boolean[m][n];
        List<Integer> list = new ArrayList<>(m * n);
        int i = 0, j = 0;
        while (cnt > 0) {
            list.add(matrix[i][j]);
            visited[i][j] = true;
            // 当前方向
            int[] direction = directions[idx];
            if (!canRun(matrix, visited, i + direction[0], j + direction[1])) {
                // 变向
                idx = (idx + 1) % 4;
                direction = directions[idx];
            }
            i += direction[0];
            j += direction[1];
            cnt--;
        }
        return list;
    }

    private boolean canRun(int[][] matrix, boolean[][] visited, int i, int j) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length && !visited[i][j];
    }
}
