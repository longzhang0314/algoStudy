package cn.zl.algo.week01.iq.exercise;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise08Test {

    public void rotate(int[][] matrix) {
        // 先沿k=-1对角线翻转，再沿中轴线翻转
        int n = matrix.length;
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
