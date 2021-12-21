package cn.zl.algo.week04.sort.exercise;

/**
 * 242. 有效的字母异位词（简单）
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 * @author liusha
 * @date 2021/12/21
 */
public class Exercise02 {

    public boolean isAnagram(String s, String t) {
        if (s == null) return t == null;
        if (t == null) return false;
        int[] arr = new int[26];
        for (char a : s.toCharArray()) {
            arr[a - 'a']++;
        }
        for (char b : t.toCharArray()) {
            arr[b - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

}
