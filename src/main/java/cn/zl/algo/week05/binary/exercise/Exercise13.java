package cn.zl.algo.week05.binary.exercise;

/**
 * 74. 搜索二维矩阵(中等)
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @author liusha
 * @date 2021/12/28
 */
public class Exercise13 {

    // 方法1：二维平铺，一次二分
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 通过mid找到行和列索引 m = 5, n = 8, mid = 19  第3行第
            int i = mid / n;
            // int j = mid % n;
            int j = mid - i * n;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


    // 方法2：两次二分
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        // 先定位到哪一行，在该行中找
        int left = 0, right = m - 1;
        // 第1列中，小于target的最大值
        int row = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }

            if (matrix[mid][0] < target && (mid == m - 1 || matrix[mid + 1][0] > target)) {
                row = mid;
                break;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (row == -1) return false;
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
