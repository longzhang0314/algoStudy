package cn.zl.algo.week05.hash.exercise;

import java.util.*;

/**
 * 349. 两个数组的交集(简单)
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * // 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * //输出：[2]
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * //输出：[9,4]
 *
 * 输出结果中的每个元素一定是唯一的。
 * // 我们可以不考虑输出结果的顺序。
 *
 * TODO 优化。用HashSet写一下
 * TODO 【扩展】K个数组的交集
 *
 * @author liusha
 * @date 2021/12/30
 */
public class Exercise12 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num1 : nums1) {
            map.put(num1, true);
        }
        List<Integer> res = new ArrayList<>();
        for (int num2 : nums2) {
            if (map.getOrDefault(num2, false)) {
                res.add(num2);
                map.put(num2, false);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
