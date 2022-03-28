package cn.zl.algo.week12.window.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 剑指 Offer 57 - II 和为s的连续正数序列
 *
 * @author liusha
 * @date 2022/3/28
 */
public class Exercise01 {

    public int[][] findContinuousSequence(int target) {
        if (target <= 2) return new int[0][0];
        int i = 1, j = 2;
        List<int[]> list = new ArrayList<>();
        while (i < j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += k;
            }
            if (sum == target) {
                int[] arr = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    arr[k - i] = k;
                }
                list.add(arr);
                i++;
                j++;
                continue;
            }
            if (sum < target) {
                j++;
            } else {
                i++;
            }
        }
        int[][] res = new int[list.size()][];
        for (i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
