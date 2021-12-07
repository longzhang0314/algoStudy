package cn.zl.algo.week01.iq.exercise;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise08Test {

    // 翻转代替旋转
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

    // 标准原地旋转
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int s1_i = 0;
        int s1_j = 0;
        while (n > 1) {
            int s2_i = 0;
            int s2_j = s1_j + n - 1;
            int s3_i = s1_i + n - 1;
            int s3_j = s1_j + n - 1;
            int s4_i = s1_i + n - 1;
            int s4_j = 0;
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
