package cn.zl.algo.week12.window.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 76.最小覆盖子串
 *
 *
 * 代码值得重写下
 *
 * @author liusha
 * @date 2022/3/28
 */
public class Exercise04 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Exercise04 e = new Exercise04();
        System.out.println(e.minWindow(s, t));
    }

    // 写法2：优于写法1
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int cnt = m;
        int[] arr = new int[52];
        // t in arr
        for (char c : t.toCharArray()) {
            arr[getIdx(c)]++;
        }

        int min = Integer.MAX_VALUE;
        String res = "";
        int l = 0, r = 0;
        while (r < n) {
            arr[getIdx(s.charAt(r))]--;
            // 大于等于0说明是有效匹配
            if (arr[getIdx(s.charAt(r))] >= 0) {
                cnt--;
            }
            if (cnt > 0) {
                r++;
                continue;
            }

            // 已满足，缩减
            while (l < r && arr[getIdx(s.charAt(l))] < 0) {
                arr[getIdx(s.charAt(l))]++;
                l++;
            }

            if (r - l + 1 < min) {
                min = r - l + 1;
                res = s.substring(l, r + 1);
            }
            // l剔出去，重新进入不满足态
            arr[getIdx(s.charAt(l))]++;
            cnt++;
            l++;
            r++;
        }

        return res;
    }

    private int getIdx(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        return 26 + (c - 'A');
    }


    // 写法1
    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] arr = new int[52];
        for (char c : t.toCharArray()) {
            arr[getIdx(c)]++;
        }
        int cnt = t.length();
        int n = s.length();
        // 窗口：[i, j)
        int i = 0, j = 0;

        int min = Integer.MAX_VALUE;
        String res = "";
        while (j < n) {
            arr[getIdx(s.charAt(j))]--;
            if (arr[getIdx(s.charAt(j))] >= 0) {
                // 有效字符
                cnt--;
            }
            // 还没凑够
            if (cnt > 0) {
                j++;
                continue;
            }

            // 缩减
            while (i <= j) {
                arr[getIdx(s.charAt(i))]++;
                if (arr[getIdx(s.charAt(i))] > 0) {
                    // 有效字符
                    if (j - i + 1 < min) {
                        min = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                    i++;
                    j++;
                    cnt++;
                    break;
                }
                i++;
            }
        }
        return res;
    }

    // 写法3：使用map替换数组，不优雅，但更具有普适性
    // 放入窗口：map--(均可), sum--(有效)
    public String minWindow3(String s, String t) {
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
