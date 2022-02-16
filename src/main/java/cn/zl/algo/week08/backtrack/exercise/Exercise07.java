package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 46. 全排列
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * //输入：nums = [1,2,3]
 * //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 多阶段决策模型改写
 *
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise07 {

    // 1.多阶段决策模型
    List<List<Integer>> res2;
    public List<List<Integer>> permute2(int[] nums) {
        res2 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        slove2(nums, list, set);
        return res2;
    }

    private void slove2(int[] nums, List<Integer> list, Set<Integer> set) {
        if (list.size() == nums.length) {
            res2.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            list.add(nums[i]);
            set.add(nums[i]);
            slove2(nums, list, set);
            set.remove(nums[i]);
            list.remove(list.size() - 1);
        }
    }


    // === 方法分隔  ===

    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove(nums, list);
        return res;
    }

    private void slove(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 这里是否可以优化时间复杂度？
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            slove(nums, list);
            list.remove(list.size() - 1);
        }
    }
}
