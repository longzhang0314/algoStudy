package cn.zl.algo.week04.sort.exercise;

import java.util.Arrays;

/**
 * 1502. 判断能否形成等差数列
 *
 * 给你一个数字数组 arr 。
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 *
 *
 * @author liusha
 * @date 2021/12/21
 */
public class Exercise03 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr == null || arr.length == 0) return true;
        Arrays.sort(arr);
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != arr[i - 1] - arr[i - 2]) {
                return false;
            }
        }
        return true;
    }

}
