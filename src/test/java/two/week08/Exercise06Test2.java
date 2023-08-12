package two.week08;

import java.util.*;

/**
 * 90
 * @author 流沙
 * @date 2023/8/12
 */
public class Exercise06Test2 {

    // 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
    //输入：nums = [1,2,2]
    //输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

    // 方法1：树形决策，每层决策时必须放入一个元素
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        // 分析：子集，为确保不重复，元素有序，有序放入
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        slove2(nums, res, list, 0);
        return res;
    }

    // 方法1：树形决策，每层决策时必须放入一个元素
    private void slove2(int[] nums, List<List<Integer>> res, List<Integer> list, int i) {
        res.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            // 同一层树中，相同值的元素只能用一次，否则：[1,2,2,2]，会产生两个[1,2,2]，且索引位置不重复
            if (j > i && nums[j] == nums[j - 1]) continue;
            list.add(nums[j]);
            slove2(nums, res, list, j + 1);
            list.remove(list.size() - 1);
        }
    }

    // ==================================方法2：================================================================

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 分析：有重复值，那么每次决策时，需要决策当前放入0个，1个，2个……
        // 实现：值去重，且计数，使用频率map即可，也可使用两个数组
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
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
        slove(res, list, cnt, val, 0);
        return res;
    }

    private void slove(List<List<Integer>> res, List<Integer> list, int[] cnt, int[] val, int i) {
        if (i == cnt.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 选任意个
        for (int j = 0; j <= cnt[i]; j++) {
            for (int k = 0; k < j; k++) {
                list.add(val[i]);
            }
            slove(res, list, cnt, val, i + 1);
            for (int k = 0; k < j; k++) {
                list.remove(list.size() - 1);
            }
        }

    }

}
