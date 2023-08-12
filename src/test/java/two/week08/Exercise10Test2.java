package two.week08;

import java.util.*;

/**
 * @author 流沙
 * @date 2023/8/12
 */
public class Exercise10Test2 {

    // 有重复值，但每个索引只能用一次，均为正数
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 方法1：决策树的当前层应该选择哪个
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        slove(candidates, target, res, list, visited, 0);
        return res;
    }

    private void slove(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, boolean[] visited, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) return;
        for (int j = i; j < candidates.length; j++) {
            // 同样的数据，前一层决策没选，这层也不选
            if (j > 0 && candidates[j] == candidates[j - 1] && !visited[j - 1]) continue;

            visited[j] = true;
            list.add(candidates[j]);
            slove(candidates, target - candidates[j], res, list, visited, j + 1);
            list.remove(list.size() - 1);
            visited[j] = false;
        }
    }


    // 方法2：决策待选的每个值
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : candidates) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int[] cnt = new int[freqMap.size()];
        int[] val = new int[freqMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            val[i] = entry.getKey();
            cnt[i] = entry.getValue();
            i++;
        }
        slove2(target, res, list, cnt, val, 0);
        return res;
    }

    private void slove2(int target, List<List<Integer>> res, List<Integer> list, int[] cnt, int[] val, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || i == cnt.length) return;

        // 决策：值选择0个或多个
        for (int k = 0; k <= cnt[i]; k++) {
            for (int j = 0; j < k; j++) {
                list.add(val[i]);
            }
            int num = val[i] * k;
            slove2(target - num, res, list, cnt, val, i + 1);
            for (int j = 0; j < k; j++) {
                list.remove(list.size() - 1);
            }
        }
    }


}
