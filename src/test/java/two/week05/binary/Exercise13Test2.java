package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/17
 */
public class Exercise13Test2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int cnt = m * n;
        int left = 0, right = cnt - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 3行3列，mid = 5   -> x=1,y=2
            int x = mid / n;
            int y = mid - x * n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
