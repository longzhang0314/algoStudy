package two.week08;

import java.util.ArrayList;
import java.util.List;

/**
 * 216
 * @author 流沙
 * @date 2023/8/12
 */
public class Exercise11Test2 {

    //找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
    //
    //
    // 只使用数字1到9
    // 每个数字 最多使用一次
    //
    //
    // 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
    //输入: k = 3, n = 7
    //输出: [[1,2,4]]
    //解释:
    //1 + 2 + 4 = 7
    // 方法1：
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 和为n，k个数，只能1-9，不可重复选择
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(k);
        slove(k, n, res, list, 1);
        return res;
    }

    private void slove(int k, int n, List<List<Integer>> res, List<Integer> list, int i) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (list.size() == k || n < 0) {
            return;
        }
        // 当前树的一层选择什么
        for (int j = i; j <= 9; j++) {
            list.add(j);
            slove(k, n - j, res, list, j + 1);
            list.remove(list.size() - 1);
        }
    }

    // 方法2：当前元素放/不放决策
    public List<List<Integer>> combinationSum2(int k, int n) {
        // 和为n，k个数，只能1-9，不可重复选择
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(k);
        slove2(res, list, k, n, 1);
        return res;
    }

    private void slove2(List<List<Integer>> res, List<Integer> list, int k, int n, int i) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i > 9 || n < 0 || list.size() == k) {
            return;
        }
        // 选/不选
        slove2(res, list, k, n, i + 1);

        list.add(i);
        slove2(res, list, k, n - i, i + 1);
        list.remove(list.size() - 1);

    }
}
