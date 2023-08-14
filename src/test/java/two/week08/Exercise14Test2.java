package two.week08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 流沙
 * @date 2023/8/14
 */
public class Exercise14Test2 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] chs = new char[n * 2];
        slove(res, chs, n, 0, 0, 0);
        return res;
    }

    private void slove(List<String> res, char[] chs, int n, int left, int right, int i) {
        if (right > left || left > n) return;
        if (i == n * 2) {
            res.add(new String(chs));
            return;
        }
        if (left > right) {
            chs[i] = ')';
            slove(res, chs, n, left, right + 1, i + 1);
        }

        chs[i] = '(';
        slove(res, chs, n, left + 1, right, i + 1);
    }
}
