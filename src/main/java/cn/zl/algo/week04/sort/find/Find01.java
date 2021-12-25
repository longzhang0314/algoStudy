package cn.zl.algo.week04.sort.find;

import java.util.Arrays;

/**
 * 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * @author: longzhang
 * @date: 2021/12/25
 */
public class Find01 {


    // 贪心 + 自定义比较器（M*logM*O(N1 + N2)）
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "0";
        int n = nums.length;
        String[] tmp = new String[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = String.valueOf(nums[i]);
        }
        // 双指针，s1,s2同时走，都没走到len时，如果同一位不相等，比较出结果
        // 如果某一位走到自己的len了，那么下一位就用另一个字符串的第一位开始代替
        // 循环到s1.len + s2.len结束
        Arrays.sort(tmp, (s1, s2) -> {
            // 从大到小排列 负数a在前，正数b在前
            char a, b;
            int l1 = s1.length(), l2 = s2.length();
            for (int i = 0; i < l1 + l2; i++) {
                if (i < l1) {
                    a = s1.charAt(i);
                } else {
                    a = s2.charAt(i - l1);
                }
                if (i < l2) {
                    b = s2.charAt(i);
                } else {
                    b = s1.charAt(i - l2);
                }
                if (a != b) {
                    return b - a;
                }
            }
            return 1;
        });

        StringBuilder sb = new StringBuilder();
        for (String s : tmp) {
            sb.append(s);
        }
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }


}
