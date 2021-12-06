package cn.zl.algo.week01.program.exercise;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise09Test {

    // 左旋转n位
    // O(N)空间，O(N)时间
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0 || n >= s.length()) return s;
        char[] chs = s.toCharArray();
        int len = chs.length;
        char[] res = new char[len];
        int k = 0;
        for (int i = n; i < len; i++) {
            res[k++] = chs[i];
        }
        for (int i = 0; i < n; i++) {
            res[k++] = chs[i];
        }
        return new String(res);
    }


    // O(N)空间，O(N)时间，一次遍历
    public String reverseLeftWords1(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0 || n >= s.length()) return s;
        char[] chs = s.toCharArray();
        int len = chs.length;
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            int newIdx = i - n >= 0 ? i - n : len + i - n;
            res[newIdx] = chs[i];
        }
        return new String(res);
    }

    // 空间O(K)
    public String reverseLeftWords2(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0 || n >= s.length()) return s;
        char[] chs = s.toCharArray();
        int len = chs.length;
        char[] tmp = new char[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = chs[i];
        }
        int k = 0;
        for (int i = n; i < len; i++) {
            chs[k++] = chs[i];
        }
        for (int i = 0; i < n; i++) {
            chs[k++] = tmp[i];
        }
        return new String(chs);
    }

    // 空间O(1), 时间O(NK)，超时
    public String reverseLeftWords3(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0 || n >= s.length()) return s;
        char[] chs = s.toCharArray();
        int len = chs.length;
        char tmp = chs[0];
        while (n > 0) {
            for (int i = 0; i < len - 1; i++) {
                chs[i] = chs[i + 1];
            }
            chs[len - 1] = tmp;
            tmp = chs[0];
            n--;
        }
        return new String(chs);
    }
}
