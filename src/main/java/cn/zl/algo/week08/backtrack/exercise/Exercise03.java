package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17.电话号码的字符组合（中等）
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise03 {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return Collections.emptyList();
        String[] model = new String[8];
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
        slove(digits, res, model, chs, 0);
        return res;
    }

    private void slove(String digits, List<String> res, String[] models, char[] chs, int i) {
        if (i == digits.length()) {
            res.add(new String(chs));
            return;
        }
        int idx = digits.charAt(i) - '2';
        String model = models[idx];
        for (char c : model.toCharArray()) {
            chs[i] = c;
            slove(digits, res, models, chs, i + 1);
        }
    }
}
