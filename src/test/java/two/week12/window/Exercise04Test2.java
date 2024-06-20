package two.week12.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 76
 * @author: longzhang
 * @date: 2024/6/20
 */
public class Exercise04Test2 {

    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return "";
        int sum = n;
        int minI = -1, minJ = -1;
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        while (r < m) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) - 1);
            int cnt = map.get(c);
            // 窗口中的有效元素
            if (cnt >= 0) {
                sum--;
            }
            if (sum > 0) {
                r++;
                continue;
            }
            // 此时sum=0，继续缩减窗口左侧：小于0说明是可以被缩减的
            while (l < r && map.get(s.charAt(l)) < 0) {
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                l++;
            }
            // 判断此时的[l,r]是否是最小的
            if (r - l + 1 < min) {
                min = r - l + 1;
                minI = l;
                minJ = r;
            }
            // 破坏窗口，收拢左侧，选取下一组
            map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
            sum++;
            l++;
            r++;
        }
        return minI == -1 ? "" : s.substring(minI, minJ + 1);
    }
}
