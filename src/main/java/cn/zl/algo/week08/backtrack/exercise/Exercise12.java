package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.Arrays;
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
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        // TODO CUR

        return null;
    }
}
