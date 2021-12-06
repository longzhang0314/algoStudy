package cn.zl.algo.week01.program.exercise;

/**
 * @author liusha
 * @date 2021/12/1
 */
public class Exercise04Test {

    // 1. split + remove word space
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            ss[i] = removeSpace(ss[i]);
            if ("".equals(ss[i])) continue;
            sb.append(ss[i]);
            sb.append(" ");
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    private String removeSpace(String s) {
        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        int end = s.length() - 1;
        while (end > start && s.charAt(end) == ' ') {
            end--;
        }
        return start > end ? "" : s.substring(start, end + 1);
    }

    // 2. reverse while loop and double pointer
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0) {
            // remove precursor space（right of end space）
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            ++start;
            // [start,end] is a word
            sb.append(s, start, end + 1);
            sb.append(" ");
            end = start - 1;
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    // 3. O(1) space when not java
    public String reverseWords3(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chs = s.toCharArray();
        // 去除中间多余的和两边的空格
        int n = trim(chs);
        if (n == 0) return "";
        reverse(chs, 0, n - 1);
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && chs[j] != ' ') {
                j++;
            }
            reverse(chs, i, j - 1);
            i = j + 1;
        }
        char[] res = new char[n];
        for (int k = 0; k < n; k++) {
            res[k] = chs[k];
        }
        return new String(res);
    }

    private int trim(char[] chs) {
        int n = chs.length;
        // 去掉前置空格
        int i = 0;
        while (i < n && chs[i] == ' ') {
            i++;
        }
        // 去掉后置空格
        int j = n - 1;
        while (j > i && chs[j] == ' ') {
            j--;
        }
        int k = 0;
        // [i,j]中去掉多余的空格,并向前挪到[0，）开始的位置
        while (i <= j) {
            if (chs[i] == ' ') {
                if (i + 1 <= j && chs[i + 1] != ' ') {
                    chs[k++] = chs[i];
                }
            } else {
                chs[k++] = chs[i];
            }
            i++;
        }
        return k;
    }

    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
    }

    // 2 retry 一次遍历，从后向前，双指针拼接StringBuilder
    public String reverseWords22(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chs = s.toCharArray();
        int r = chs.length - 1;
        StringBuilder sb = new StringBuilder();
        while (r >= 0) {
            // 去除右边空格
            if (chs[r] == ' ') {
                r--;
                continue;
            }
            int l = r - 1;
            while (l >= 0 && chs[l] != ' ') {
                l--;
            }
            ++l;
            sb.append(s, l, r + 1);
            sb.append(" ");
            r = l - 1;
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }


}
