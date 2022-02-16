package cn.zl.algo.week08.backtrack.exercise;

import java.util.*;

/**
 * 90.子集2（有重复元素，但同一个位置不能重复使用）
 * <p>
 * 【注意】非常经典，用多阶段决策模型推敲去重方法并重写  cnt数组，决策放0个，1个，2个这种方法
 *
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise06 {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        // 转化两个数组，频率数组和value数组
        int[] cntArr = new int[cntMap.size()];
        int[] valArr = new int[cntMap.size()];
        int i = 0;
        for (int num : nums) {
            Integer cnt = cntMap.get(num);
            if (cnt == null) continue;
            cntArr[i] = cnt;
            valArr[i] = num;
            i++;
            cntMap.remove(num);
        }

        System.out.println("cnt数组：");
        for (int c : cntArr) {
            System.out.println(c);
        }

        System.out.println("val数组：");
        for (int v : valArr) {
            System.out.println(v);
        }
    }

    List<List<Integer>> res2;
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        res2 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        // 转化两个数组，频率数组和value数组
        int[] cntArr = new int[cntMap.size()];
        int[] valArr = new int[cntMap.size()];
        int i = 0;
        for (int num : nums) {
            Integer cnt = cntMap.get(num);
            if (cnt == null) continue;
            cntArr[i] = cnt;
            valArr[i] = num;
            i++;
            cntMap.remove(num);
        }

        slove2(cntArr, valArr, list, 0);
        return res2;
    }

    private void slove2(int[] cntArr, int[] valArr, List<Integer> list, int i) {
        if (i == cntArr.length) {
            res2.add(new ArrayList<>(list));
            return;
        }
        // 多阶段决策：每个值选0个，1个，2个...
        for (int k = 0; k <= cntArr[i]; k++) {
            // 当前阶段值选k个
            for (int j = 0; j < k; j++) {
                list.add(valArr[i]);
            }
            slove2(cntArr, valArr, list, i + 1);
            for (int j = 0; j < k; j++) {
                list.remove(list.size() - 1);
            }
        }
    }

    // =================== 方法1：cnt数组，决策放0个，1个，2个  方法分隔符  方法2：先排序，遍历过程中去重  ===================

    // ====== 排序写法2 ===

    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove(nums, list, 0);
        return res;
    }

    private void slove(int[] nums, List<Integer> list, int i) {
        res.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            // 重复情况过滤
            if (j > i && nums[j] == nums[j - 1]) continue;
            list.add(nums[j]);
            // 不允许元素重复放入
            slove(nums, list, j + 1);
            list.remove(list.size() - 1);
        }
    }

}
