package cn.zl.algo.week12.window.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @author liusha
 * @date 2022/3/28
 */
public class Exercise03 {


    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        int[] arr = new int[26];
        for (char c : p.toCharArray()) {
            arr[c - 'a']++;
        }
        int cnt = p.length();
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        int i = 0, j = cnt - 1;
        for (int k = i; k <= j; k++) {
            arr[s.charAt(k) - 'a']--;
            if (arr[s.charAt(k) - 'a'] >= 0) {
                cnt--;
            }
        }
        if (cnt == 0) {
            res.add(i);
        }

        while (j + 1 < n) {
            arr[s.charAt(i) - 'a']++;
            if (arr[s.charAt(i) - 'a'] > 0) {
                cnt++;
            }
            i++;
            j++;
            arr[s.charAt(j) - 'a']--;
            if (arr[s.charAt(j) - 'a'] >= 0) {
                cnt--;
            }
            if (cnt == 0) {
                res.add(i);
            }
        }

        return res;
    }
}
