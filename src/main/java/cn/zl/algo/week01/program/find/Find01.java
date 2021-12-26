package cn.zl.algo.week01.program.find;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: longzhang
 * @date: 2021/12/26
 */
public class Find01 {

    public static void main(String[] args) {
        Find01 f = new Find01();
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        String[] ss = f.findOcurrences(text, first, second);
        for (String s : ss) {
            System.out.println(s);
        }
    }

    public String[] findOcurrences(String text, String first, String second) {
        char[] chs = text.toCharArray();
        char[] f = first.toCharArray();
        char[] s = second.toCharArray();
        int i = 0, n = chs.length;
        List<String> ans = new ArrayList<>();
        while (i < n) {
            int j = i;
            while (j < n && chs[j] != ' ') {
                j++;
            }
            // [i, j)字符串
            boolean isFirst = isWord(chs, i, j - 1, f);
            if (isFirst && j + 1 < n) {
                i = j + 1;
                j = i;

                int oldI = i;
                while (j < n && chs[j] != ' ') {
                    j++;
                }
                boolean isSecond = isWord(chs, i, j - 1, s);
                if (isSecond && j + 1 < n) {
                    i = j + 1;
                    j = i;
                    while (j < n && chs[j] != ' ') {
                        j++;
                    }
                    ans.add(new String(chs, i, j - i));
                    i = oldI;
                } else {
                    i = oldI;
                }
            } else {
                i = j + 1;
            }
        }

        String[] res = new String[ans.size()];
        int idx = 0;
        for (String cur : ans) {
            res[idx++] = cur;
        }
        return res;
    }


    private boolean isWord(char[] chs, int i, int j, char[] model) {
        if (j - i + 1 != model.length) return false;
        int k = 0;
        while (i <= j) {
            if (chs[i] != model[k]) return false;
            i++;
            k++;
        }
        return true;
    }

}
