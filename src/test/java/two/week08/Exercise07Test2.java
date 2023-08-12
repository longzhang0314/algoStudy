package two.week08;

import java.util.ArrayList;
import java.util.List;

/**
 * 46
 * @author 流沙
 * @date 2023/8/12
 */
public class Exercise07Test2 {


    // 不重复
    public List<List<Integer>> permute2(int[] nums) {
        // 方法1：树形决策，每层任选一个，使用数组去重
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        slove2(nums, res, list, visited);
        return res;
    }

    private void slove2(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 决策：任意选择一个
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            slove2(nums, res, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
