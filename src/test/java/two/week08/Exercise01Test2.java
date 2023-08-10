package two.week08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: longzhang
 * @date: 2023/8/10
 */
public class Exercise01Test2 {

    // 用Q和.表示
    public List<List<String>> solveNQueens2(int n) {
        if (n <= 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        char[][] chs = new char[n][n];
        for (char[] ch : chs) {
            Arrays.fill(ch, '.');
        }
        slove(res, chs, n, 0);
        return res;
    }

    private void slove(List<List<String>> res, char[][] chs, int n, int i) {
        if (i == n) {
            List<String> snapshot = new ArrayList<>(n);
            for (char[] ch : chs) {
                snapshot.add(new String(ch));
            }
            res.add(new ArrayList<>(snapshot));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (check(chs, i, j)) {
                chs[i][j] = 'Q';
                slove(res, chs, n, i + 1);
                chs[i][j] = '.';
            }
        }
    }

    private boolean check(char[][] chs, int i, int j) {
        int left = j - 1, right = j + 1;
        while (--i >= 0) {
            if (chs[i][j] == 'Q') return false;
            if (left >= 0 && chs[i][left] == 'Q') return false;
            if (right < chs.length && chs[i][right] == 'Q') return false;
            left--;
            right++;
        }
        return true;
    }


    //  方法2：一维数组

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        int[] chs = new int[n];
        process(res, chs, 0, n);
        return res;
    }

    private void process(List<List<String>> res, int[] chs, int i, int n) {
        if (i == n) {
            addToRes(chs, res);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(chs, i, j)) {
                chs[i] = j;
                process(res, chs, i + 1, n);
            }
        }
    }

    private void addToRes(int[] chs, List<List<String>> res) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chs.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chs.length; j++) {
                if (chs[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }

    private boolean isValid(int[] chs, int i, int j) {
        int left = j - 1, right = j + 1;
        while (--i >= 0) {
            if (chs[i] == j) return false;
            if (left >= 0 && chs[i] == left) return false;
            if (right < chs.length && chs[i] == right) return false;
            left--;
            right++;
        }
        return true;
    }


}
