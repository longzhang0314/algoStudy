package cn.zl.algo.week01.iq.exercise;

/**
 * 48. 旋转图像 （中等）经典
 *
 * 3种方法：tmp数组，翻转（两种），标准原地旋转
 * 【注意】原地旋转解法；
 * TODO 拓展题型：m * n
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
    // 方法1：翻转解法
    // 先沿左上右下对角线翻转，然后左右翻转
    // 也可以：先上下翻转，然后沿左上右下对角线翻转
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

    // 方法2：临时数组，力扣不允许
    public void rotate2(int[][] matrix) {
        if (matrix == null) return;
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = matrix[i][j];
            }
        }
        // 旋转 行变列，第一行在最后一列 a[i][j] = a[j][n - i - 1]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = tmp[j][n - 1 - i];
            }
        }
    }


    // 方法3：标准原地旋转
    public void rotate3(int[][] matrix) {
        if (matrix == null) return;
        int n = matrix.length;
        int s1_i = 0;
        int s1_j = 0;
        while (n > 1) {
            // 基准点
            int s2_i = s1_i;
            int s2_j = n - 1 + s1_j;
            int s3_i = n - 1 + s1_i;
            int s3_j = n - 1 + s1_j;
            int s4_i = n - 1 + s1_i;
            int s4_j = s1_j;
            for (int move = 0; move <= n - 2; move++) {
                int p1_i = s1_i;
                int p1_j = s1_j + move;
                int p2_i = s2_i + move;
                int p2_j = s2_j;
                int p3_i = s3_i;
                int p3_j = s3_j - move;
                int p4_i = s4_i - move;
                int p4_j = s4_j;
                swap4(matrix, p1_i, p1_j, p2_i, p2_j, p3_i, p3_j, p4_i, p4_j);
            }
            s1_i++;
            s1_j++;
            n -= 2;
        }
    }

    private void swap4(int[][] matrix, int p1_i, int p1_j, int p2_i, int p2_j, int p3_i, int p3_j, int p4_i, int p4_j) {
        int tmp = matrix[p1_i][p1_j];
        matrix[p1_i][p1_j] = matrix[p4_i][p4_j];
        matrix[p4_i][p4_j] = matrix[p3_i][p3_j];
        matrix[p3_i][p3_j] = matrix[p2_i][p2_j];
        matrix[p2_i][p2_j] = tmp;
    }
}
