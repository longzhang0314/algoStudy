package two.week12.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 438. 找到字符串中所有字母异位词
 *
 * @author: longzhang
 * @date: 2024/6/19
 */
public class Exercise03Test2 {

    public static void main(String[] args) {
        Exercise03Test2 e = new Exercise03Test2();
        System.out.println(e.findAnagrams("abab", "ab")); // [0,1,2]
    }


    public List<Integer> findAnagrams(String s, String p) {
        // 滑动窗口，并逐渐对比
        // 维护全局变量：可被异位的个数，当其等于0，且最后一位字母异位词计算后刚好为0时，当前为子串
        if (s == null || p == null || s.length() < p.length() || p.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int sum = p.length();
        // 存在的字母才减，不存在的字母不减
        // 若存在的字母减为负数时，sum不变
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int m = s.length(), n = p.length();
        for (int i = 0; i <= m - n; i++) {
            int j = i + n - 1;
            // 第一个窗口特殊处理，全部走一遍
            if (i == 0) {
                for (int k = i ; k <= j; k++) {
                    char c = s.charAt(k);
                    if (!map.containsKey(c)) continue;
                    map.put(c, map.get(c) - 1);
                    int cnt = map.get(c);
                    if (cnt >= 0) sum--;
                }
                if (sum == 0) res.add(i);
                continue;
            }
            // 非0情况，弹出i-1，放入j即可
            char c =  s.charAt(i - 1);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                int cnt = map.get(c);
                if (cnt > 0) sum++;
            }
            char d = s.charAt(j);
            if (map.containsKey(d)) {
                map.put(d, map.get(d) - 1);
                int cnt = map.get(d);
                if (cnt >= 0) sum--;
            }
            if (sum == 0) res.add(i);
        }
        return res;
    }
}
