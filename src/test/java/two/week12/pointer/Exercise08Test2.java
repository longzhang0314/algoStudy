package two.week12.pointer;

import java.util.Arrays;

/**
 * @author 流沙
 * @date 2024/4/8
 */
public class Exercise08Test2 {

    // 最小差绝对值
    public int smallestDifference(int[] a, int[] b) {
        if (a == null || b == null) return 0;
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0, m = a.length, n = b.length;
        int min = Integer.MAX_VALUE;
        while (i < m && j < n) {
            int sub = Math.abs(a[i] -b[j]);
            // 超出会值为Integer.MIN_VALUE，且其绝对值一定不是最小值
            if (sub != Integer.MIN_VALUE && Math.abs(sub) < min) {
                min = sub;
            }
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                return 0;
            }
        }
        return min;
    }
}
