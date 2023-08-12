package two.week08;

import java.util.*;

/**
 * 47
 * @author 流沙
 * @date 2023/8/12
 */
public class Exercise08Test2 {

    // 方法1：树的每层决策(本质：决策取数方案)
    public List<List<Integer>> permuteUnique2(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(nums.length);
        boolean[] visited = new boolean[nums.length];
        slove2(nums, res, list, visited);
        return res;
    }

    private void slove2(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 决策：当前树需要选哪个
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            // 相同的数同一层不重复选
            // 1 2 2，如果在上一层没选2，那么这一层也不能选；原因：上一层选2和不选2是两种情况，如果在上一层不选2的情况下，这一层要选2，那和上一层选2的结果重复了
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            slove2(nums, res, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    // === 方法2：对每个数决策（本质：决策生成结果）
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 记录每个位置的数的个数，每次决策：当前位置需要放哪个数？重复的数认为是同一种决策
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(nums.length);
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int[] cnt = new int[freqMap.size()];
        int[] val = new int[freqMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            cnt[i] = entry.getValue();
            val[i] = entry.getKey();
            i++;
        }
        slove(nums, res, list, val, cnt);
        return res;
    }

    private void slove(int[] nums, List<List<Integer>> res, List<Integer> list, int[] val, int[] cnt) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < val.length; i++) {
            if (cnt[i] == 0) continue;
            list.add(val[i]);
            cnt[i]--;
            slove(nums, res, list, val, cnt);
            cnt[i]++;
            list.remove(list.size() - 1);
        }
    }

}
