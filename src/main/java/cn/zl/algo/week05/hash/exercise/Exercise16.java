package cn.zl.algo.week05.hash.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 16.21. 交换和（中等） 找规律，可以借助哈希表优化
 *
 * @author liusha
 * @date 2022/1/2
 */
public class Exercise16 {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int m = array1.length, n = array2.length;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < m; i++) {
            sum1 += array1[i];
        }
        for (int i = 0; i < n; i++) {
            sum2 += array2[i];
        }
        // 两个数元素交换后，一个数组和+a，另一个一定-a，说明交换前差值为2a
        int diff = sum1 - sum2;
        if (diff % 2 != 0) return new int[0];
        diff /= 2;
        Set<Integer> set = new HashSet<>();
        for (int a2 : array2) {
            set.add(a2);
        }
        for (int a1 : array1) {
            if (set.contains(a1 - diff)) return new int[]{a1, a1 - diff};
        }
        return new int[0];
    }

}
