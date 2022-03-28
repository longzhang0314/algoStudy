package cn.zl.algo.week12.window.exercise;

/**
 * 76.最小覆盖子串
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

    public String minWindow(String s, String t) {
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

    private int getIdx(char c) {
        // 0 - 25
        if (c >= 'a' && c <= 'z') return c - 'a';
        if (c >= 'A' && c <= 'Z') return c - 'A' + 26;
        return -1;
    }
}
