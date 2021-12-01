package cn.zl.algo.week01.iq.exercise;

/**
 * 面试题 01.08. 零矩阵（简单）
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
public class Exercise01 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        // 默认值false表示不清除，true表示遇到0清除该行
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i]) {
                    matrix[i][j] = 0;
                }
                if (col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
