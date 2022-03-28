package cn.zl.algo.week12.window.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48]最长不含重复字符的子字符串
 *
 * @author liusha
 * @date 2022/3/28
 */
public class Exercise02 {


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int max = 1;
        while (j < n) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            int len = j - i + 1;
            if (len > max) {
                max = len;
            }
            j++;
        }
        return max;
    }
}
