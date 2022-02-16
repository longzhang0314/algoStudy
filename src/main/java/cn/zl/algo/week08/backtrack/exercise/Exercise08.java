package cn.zl.algo.week08.backtrack.exercise;

import java.util.*;

/**
 * 47. 全排列2
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * //输入：nums = [1,1,2]
 * //输出：
 * //[[1,1,2],
 * // [1,2,1],
 * // [2,1,1]]
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [1,2,3]
 * //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * TODO do 重复
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise08 {


    // 多阶段决策：统计个数
    List<List<Integer>> res2;
    public List<List<Integer>> permuteUnique2(int[] nums) {
        res2 = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] cntArr = new int[freq.size()];
        int[] valArr = new int[freq.size()];
        int i = 0;
        for (int num : nums) {
            int cnt = freq.getOrDefault(num, 0);
            if (cnt == 0) continue;
            cntArr[i] = cnt;
            valArr[i] = num;
            i++;
            freq.remove(num);
        }
        List<Integer> list = new ArrayList<>();
        slove2(cntArr, valArr, list, nums.length);
        return res2;
    }

    private void slove2(int[] cntArr, int[] valArr, List<Integer> list, int n) {
        if (list.size() == n) {
            res2.add(new ArrayList<>(list));
            return;
        }
        // 当前这一层决策哪个数
        for (int i = 0; i < valArr.length; i++) {
            // 可选列表
            if (cntArr[i] == 0) continue;
            list.add(valArr[i]);
            cntArr[i]--;
            slove2(cntArr, valArr, list, n);
            cntArr[i]++;
            list.remove(list.size() - 1);
        }
    }


    // =========  方法分隔线 =====


    List<List<Integer>> res;
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        slove(nums, list);
        return res;
    }

    private void slove(int[] nums, List<Integer> list) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            // 前一个数没选，后一个也不能选，否则会是同一种情况
            // 前一个数选了，后一个可选可不选
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            slove(nums, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

}
