package cn.zl.algo.week05.hash.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 16.21. 交换和（中等） 找规律，可以借助哈希表优化
 *
 * 【注意】思路证明
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
        // 假设数组1更大，如果小，这里是负数
        int diff = sum1 - sum2;
        // 差值为计数无法使相等
        if (diff % 2 != 0) return new int[0];
        diff /= 2;
        // 一个数组+diff，一个数组-diff，我们假设数组1更大，所以数组1-diff,数组2+diff
        // 把数组2的数全部存到set中，对于每个数组1的数，如果set存在num1-diff，那么两数交换
        Set<Integer> set = new HashSet<>();
        for (int num2 : array2) {
            set.add(num2);
        }
        for (int num1 : array1) {
            if (set.contains(num1 - diff)) {
                return new int[]{num1, num1 - diff};
            }
        }
        return new int[0];
    }

}
