package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成（中等）
 * @author: longzhang
 * @date: 2022/2/13
 */
public class Exercise14 {

    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n <= 0) return res;
        char[] chs = new char[n * 2];
        slove(chs, n, 0, 0, 0);
        return res;
    }

    private void slove(char[] chs, int n, int left, int right, int cnt) {
        if (cnt == n * 2) {
            if (left == n && right == n) {
                res.add(new String(chs));
            }
            return;
        }

        if (left < n) {
            chs[cnt] = '(';
            slove(chs, n, left + 1, right, cnt + 1);
        }

        if (right < left) {
            chs[cnt] = ')';
            slove(chs, n, left, right + 1, cnt + 1);
        }
    }
}
