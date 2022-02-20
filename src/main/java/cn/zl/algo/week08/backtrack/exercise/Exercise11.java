package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 216.组合总和3（中等）
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * @author liusha
 * @date 2022/2/9
 */
public class Exercise11 {

    // 多阶段决策模型套路解决
    List<List<Integer>> res2 = new ArrayList<>();
    public List<List<Integer>> combinationSum33(int k, int n) {
        List<Integer> list = new ArrayList<>();
        slove2(k, n, list, 1);
        return res2;
    }

    private void slove2(int k, int n, List<Integer> list, int i) {
        if (n <= 0 || list.size() == k || i == 10) {
            if (list.size() == k && n == 0) {
                res2.add(new ArrayList<>(list));
            }
            return;
        }
        // 不选
        slove2(k, n, list, i + 1);
        // 选
        list.add(i);
        slove2(k, n - i, list, i + 1);
        list.remove(list.size() - 1);
    }


    // ===================== 方法分割线 ==================

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
