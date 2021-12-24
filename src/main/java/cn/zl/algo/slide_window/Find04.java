package cn.zl.algo.slide_window;

/**
 * 567. 字符串的排列
 *
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * @author: longzhang
 * @date: 2021/12/23
 */
public class Find04 {

    public static void main(String[] args) {
        Find04 f = new Find04();
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(f.checkInclusion(s1, s2));
    }


    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() > s2.length()) return false;
        int[] cnt = new int[26];
        int totalCnt = 0;
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
            totalCnt++;
        }
        // 滑动窗口初始值
        int left = 0, right = s1.length() - 1;
        for (int i = left; i <= right; i++) {
            cnt[s2.charAt(i) - 'a']--;
            if (cnt[s2.charAt(i) - 'a'] >= 0) {
                totalCnt--;
            }
        }
        if (totalCnt == 0) return true;

        while (right + 1 < s2.length()) {
            cnt[s2.charAt(left) - 'a']++;
            if (cnt[s2.charAt(left) - 'a'] > 0) {
                totalCnt++;
            }
            left++;
            right++;
            cnt[s2.charAt(right) - 'a']--;
            if (cnt[s2.charAt(right) - 'a'] >= 0) {
                totalCnt--;
            }
            if (totalCnt == 0) return true;
        }
        return false;
    }
}
