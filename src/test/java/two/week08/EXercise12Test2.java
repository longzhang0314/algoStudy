package two.week08;

import java.util.ArrayList;
import java.util.List;

/**
 * 131
 * @author 流沙
 * @date 2023/8/14
 */
public class EXercise12Test2 {

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        slove(res, list, s, 0);
        return res;
    }

    private void slove(List<List<String>> res, List<String> list, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = start; j < s.length(); j++) {
            if (valid(s, start, j)) {
                list.add(s.substring(start, j + 1));
                slove(res, list, s, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
