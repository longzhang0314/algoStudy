package cn.zl.algo.week08.backtrack.exercise;

import java.util.*;

/**
 * 40. 组合总和2（中等）
 *
 * //给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * //
 * // candidates 中的每个数字在每个组合中只能使用 一次 。
 * //
 * // 注意：解集不能包含重复的组合。
 *
 * @author liusha
 * @date 2022/2/9
 */
public class Exercise10 {

    // 多阶段决策法：决策转换
    List<List<Integer>> res2 = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int c : candidates) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int[] cntArr = new int[freq.size()];
        int[] valArr = new int[freq.size()];
        int i = 0;
        for (int c : candidates) {
            int cnt = freq.getOrDefault(c, 0);
            if (cnt == 0) continue;
            cntArr[i] = cnt;
            valArr[i] = c;
            i++;
            freq.remove(c);
        }

        slove2(cntArr, valArr, target, new ArrayList<>(), 0);
        return res2;
    }

    private void slove2(int[] cntArr, int[] valArr, int target,  List<Integer> list, int i) {
        if (i == cntArr.length || target <= 0) {
            if (target == 0) {
                res2.add(new ArrayList<>(list));
            }
            return;
        }
        // 多阶段决策，当前这个数选0个到cnt个
        int cnt = cntArr[i];
        for (int k = 0; k <= cnt; k++) {
            for (int j = 0; j < k; j++) {
                list.add(valArr[i]);
                target -= valArr[i];
            }
            slove2(cntArr, valArr, target, list, i + 1);
            for (int j = 0; j < k; j++) {
                list.remove(list.size() - 1);
                target += valArr[i];
            }
        }
    }


    // ===== 方法分隔 ===



    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        slove(candidates, target, visited, 0, new ArrayList<>());
        return res;
    }

    private void slove(int[] candidates, int target, boolean[] visited, int i, List<Integer> list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1] && !visited[j - 1]) continue;
            visited[j] = true;
            list.add(candidates[j]);
            slove(candidates, target - candidates[j], visited, j + 1, list);
            list.remove(list.size() - 1);
            visited[j] = false;
        }
    }
}
