package cn.zl.algo.week12.pointer.exercise;

import java.util.Arrays;

/**
 * 面试题 16.06 最小差
 *
 * @author liusha
 * @date 2022/3/24
 */
public class Exercise08 {

    public int smallestDifference(int[] a, int[] b) {
        //-2147483648，1
        Arrays.sort(a);
        //0,2147483647
        Arrays.sort(b);
        int i = 0, j = 0, m = a.length, n = b.length;
        int min = Integer.MAX_VALUE;
        while (i < m && j < n) {
            int val = a[i] - b[j];
            if (val != Integer.MIN_VALUE && Math.abs(val) < min) {
                min = Math.abs(val);
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
