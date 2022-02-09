package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和2（中等）
 * @author liusha
 * @date 2022/2/9
 */
public class Exercise10 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
