package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址（中等）
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * @author: longzhang
 * @date: 2022/2/13
 */
public class Exercise13 {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s == null || s.length() < 4) return res;
        String[] tmp = new String[4];
        slove(s, tmp, 0, 0);
        return res;
    }

    private void slove(String s, String[] tmp, int i, int k) {
        if (tmp.length == k) {
            if (i == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (String t : tmp) {
                    sb.append(t).append(".");
                }
                res.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        for (int j = i + 1; j <= s.length() && j <= i + 3; j++) {
            String sub = s.substring(i, j);
            if (isValid(sub)) {
                tmp[k] = sub;
                slove(s, tmp, j, k + 1);
            }
        }
    }

    private boolean isValid(String s) {
        int digit = 0;
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        for (char c : s.toCharArray()) {
            digit = digit * 10 + (c - '0');
        }
        return digit >= 0 && digit <= 255;
    }
}
