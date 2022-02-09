package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 216.组合总和3（中等）
 * @author liusha
 * @date 2022/2/9
 */
public class Exercise11 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        slove(list, k, n, 1);
        return res;
    }

    private void slove(List<Integer> list, int k, int n, int i) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (list.size() == k || n <= 0) {
            return;
        }
        for (int j = i; j <= 9; j++) {
            list.add(j);
            slove(list, k, n - j, j + 1);
            list.remove(list.size() - 1);
        }
    }

}
