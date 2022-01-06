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
 * 【扩展】K个数组的交集
 *
 * @author liusha
 * @date 2021/12/30
 */
public class Exercise12 {

    // hashset
    public int[] intersection1(int[] nums1, int[] nums2) {
        // 长的是num1,短的是nums2
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        if (nums1.length < nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Set<Integer> set = new HashSet<>();
        for (int num2 : nums2) {
            set.add(num2);
        }
        List<Integer> res = new ArrayList<>();
        for (int num1 : nums1) {
            if (set.contains(num1)) {
                res.add(num1);
                set.remove(num1);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    // hashmap
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
