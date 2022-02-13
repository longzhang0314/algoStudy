package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * TODO do 这个系列题目用背包的方式重写
 *
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise04 {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove(n, k, list, 1);
        return res;
    }

    private void slove(int n, int k, List<Integer> list, int i) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j <= n; j++) {
            list.add(j);
            slove(n, k, list, j + 1);
            list.remove(list.size() - 1);
        }
    }
}
