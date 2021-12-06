package cn.zl.algo.week01.iq.exercise;

/**
 * 48. 旋转图像 （中等）经典
 */
public class Exercise08 {

    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     *
     * 需要先举例观察规律。
     *
     * 1 2 3      7 4 1
     * 4 5 6      8 5 2
     * 7 8 9      9 6 3
     *
     * 1   2   3   4
     * 5   6   7   8
     * 9  10  11  12
     * 13 14  15  16
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) return;
        int n = matrix.length;
        // 行变列，列变行
        // 先按照 k = -1这条线翻转，然后按照中轴线翻转

        // 按照k = -1翻转
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // a[1][0] -> a[0][1], a[2][1] -> a[1][2]
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 按照中轴线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }

    }
}
