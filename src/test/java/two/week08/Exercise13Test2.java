package two.week08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 流沙
 * @date 2023/8/14
 */
public class Exercise13Test2 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>(4);
        slove(s, res, list, 0);
        return res;
    }

    private void slove(String s, List<String> res, List<String> list, int i) {
        if (list.size() == 4 && i == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String ss : list) {
                sb.append(ss).append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        } else if (list.size() == 4 || i == s.length()) {
            return;
        }

        for (int j = i; j < s.length() && j < i + 3; j++) {
            if (valid(s, i, j)) {
                list.add(s.substring(i, j + 1));
                slove(s, res, list, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean valid(String s, int i, int j) {
        if (s.charAt(i) == '0' && i != j) return false;
        int num = 0;
        while (i <= j) {
            num = num * 10 + (s.charAt(i++) - '0');
        }
        return num >= 0 && num <= 255;
    }
}