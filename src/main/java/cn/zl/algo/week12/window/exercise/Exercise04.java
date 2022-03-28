package cn.zl.algo.week12.window.exercise;

/**
 * 76.
 *
 * TODO
 * @author liusha
 * @date 2022/3/28
 */
public class Exercise04 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] arr = new int[52];
        for (char c : t.toCharArray()) {
            arr[getIdx(c)]++;
        }
        int cnt = t.length();
        int n = s.length();
        int i = 0, j = cnt - 1;
        for (int k = i; k <= j; k++) {
            arr[getIdx(s.charAt(k))]--;
            if (arr[getIdx(s.charAt(k))] >= 0) {
                cnt--;
            }
        }
        if (cnt == 0) {
            return s.substring(i, j + 1);
        }

        while (j + 1 < n) {
            j++;
            arr[getIdx(s.charAt(j))]--;
            if (arr[getIdx(s.charAt(j))] >= 0) {
                cnt--;
            }
            if (cnt == 0) break;
        }
        if (j + 1 == n) return "";
        // 收缩
        while (i < j) {

        }
    }

    private int getIdx(char c) {

    }
}
