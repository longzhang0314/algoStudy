package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * 1到n，n个数，组成k个数，找出所有组合，不能重复
 *
 * 【注意】这个系列题目用背包的方式重写
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

    // =================================== 背包方式 ===========================================================
    List<List<Integer>> res2;
    public List<List<Integer>> combine2(int n, int k) {
        res2 = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res2;
        }
        List<Integer> list = new ArrayList<>(k);
        slove2(n, k, list, 1);
        return res2;
    }

    private void slove2(int n, int k, List<Integer> list, int i) {
        if (list.size() == k) {
            res2.add(new ArrayList<>(list));
            return;
        }
        if (i == n + 1) {
            return;
        }

        // 不选
        slove2(n, k, list, i + 1);
        // 选
        list.add(i);
        slove2(n, k, list, i + 1);
        list.remove(list.size() - 1);
    }
}
