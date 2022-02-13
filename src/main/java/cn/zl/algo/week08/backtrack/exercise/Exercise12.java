package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 131.分割回文串（中等）
 * @author liusha
 * @date 2022/2/9
 */
public class Exercise12 {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return res;
        List<String> list = new ArrayList<>();
        slove(s, list, 0);
        return res;
    }

    private void slove(String s, List<String> list, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (isValid(sub)) {
                list.add(sub);
                slove(s, list, j);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
