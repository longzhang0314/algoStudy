package two.week08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 流沙
 * @date 2023/8/12
 */
public class Exercise05Test2 {

    public List<List<Integer>> subsets(int[] nums) {
        // 分析：子集中仍然是组合，顺序排布
        // 分析：nums中互不重复，先排序，按序选取
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>(nums.length);
        slove(nums, res, list, 0);
        return res;
    }

    private void slove(int[] nums, List<List<Integer>> res, List<Integer> list, int i) {
        res.add(new ArrayList<>(list));

        // 每层树必须要选择一个元素
        for (int j = i; j < nums.length; j++) {
            list.add(j);
            slove(nums, res, list, j + 1);
            list.remove(list.size() - 1);
        }
    }
}
