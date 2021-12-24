package cn.zl.algo.slide_window;

/**
 * 76. 最小覆盖子串
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 *
 * @author: longzhang
 * @date: 2021/12/23
 */
public class Find02 {


    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) return "";
        // 用一个int数组存储t中每个字符出现的个数，并记录总个数
        // 当s命中t中某个字符时，当前字符出现个数-1，总个数-1（总个数变化不依赖负值）
        // 当总个数等于0时，统计长度，修改res
        // 滑动窗口核心逻辑：右边不断扩大，当cnt = 0时，更新res，并不断左边出队
        int[] cnt = new int[52];
        int totalCnt = 0;
        for (char c : t.toCharArray()) {
            cnt[calcIdx(c)]++;
            totalCnt++;
        }

        int left = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cntIdx = calcIdx(c);
            cnt[cntIdx]--;
            if (cnt[cntIdx] >= 0) {
                totalCnt--;
            }
            if (totalCnt == 0) {
                while (left < i && cnt[calcIdx(s.charAt(left))] < 0) {
                    cnt[calcIdx(s.charAt(left))]++;
                    left++;
                }
                if (i - left + 1 < min) {
                    min = i - left + 1;
                    res = s.substring(left, i + 1);
                }
                cnt[calcIdx(s.charAt(left))]++;
                totalCnt++;
                left++;
            }

        }

        return res;

    }

    // a - z [0,25] A - Z [26,51]
    private int calcIdx(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        if (c >= 'A' && c <= 'Z') return (c - 'A') + 26;
        return -1;
    }
}
