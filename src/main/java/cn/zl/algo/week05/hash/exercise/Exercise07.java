package cn.zl.algo.week05.hash.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02  判定是否互为字符重排(简单)
 * @author: longzhang
 * @date: 2021/12/29
 */
public class Exercise07 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null) return s2 == null;
        if (s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            cnt++;
        }
        for (char c : s2.toCharArray()) {
            if (map.getOrDefault(c, 0) > 0) {
                map.put(c, map.get(c) - 1);
                cnt--;
            }
        }
        return cnt == 0;
    }
}
