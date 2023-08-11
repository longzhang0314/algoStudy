package two.week08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 流沙
 * @date 2023/8/11
 */
public class Exercise03Test2 {

//    model[0] = "abc";
//    model[1] = "def";
//    model[2] = "ghi";
//    model[3] = "jkl";
//    model[4] = "mno";
//    model[5] = "pqrs";
//    model[6] = "tuv";
//    model[7] = "wxyz";
    // digits : 13311111111
    String[] model;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        model = new String[digits.length()];
        model[0] = "abc";
        model[1] = "def";
        model[2] = "ghi";
        model[3] = "jkl";
        model[4] = "mno";
        model[5] = "pqrs";
        model[6] = "tuv";
        model[7] = "wxyz";
        List<String> res = new ArrayList<>();
        char[] chs = new char[digits.length()];
        slove(res, digits, chs, 0);
        return res;
    }

    private void slove(List<String> res, String digits, char[] chs, int i) {
        if (i == digits.length()) {
            res.add(new String(chs));
            return;
        }
        int idx = digits.charAt(i) - '2';

        for (char c : model[idx].toCharArray()) {
            chs[i] = c;
            slove(res, digits, chs, i + 1);
        }
    }
}
