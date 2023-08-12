package two.week08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 流沙
 * @date 2023/8/12
 */
public class Exercise04Test2 {

    public static void main(String[] args) {
        Exercise04Test2 e = new Exercise04Test2();
        int n = 4, k = 2;
        System.out.println(e.combine(n, k));
    }

    // 1到n，n个数，组成k个数，找出所有组合，不能重复
    public List<List<Integer>> combine(int n, int k) {
        // 分析：组合，所以每种组合都是小的在前，大的在后；所以下一个位置一定比当前位置的值小
        if (n <= 0 || n < k) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(k);
        slove(res, list, n, k, 1);
        return res;
    }

    private void slove(List<List<Integer>> res, List<Integer> list, int n, int k, int i) {
        if (i > n) {
            return;
        }
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 对当前数字进行决策：选/不选
        // 不选
        slove(res, list, n, k, i + 1);
        // 选
        list.add(i);
        slove(res, list, n, k, i + 1);
        list.remove(list.size() - 1);
    }


    //  ==================     非back======

    public List<List<Integer>> combine2(int n, int k) {
        if (n <= 0 || n < k) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(k);
        slove2(res, list, n, k, 1);
        return res;
    }

    private void slove2(List<List<Integer>> res, List<Integer> list, int n, int k, int i) {
        if (i > n) {
            return;
        }
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 按树的深度展开，每层必须选一个
        for (int j = i; j <= n; j++) {
            list.add(j);
            slove(res, list, n, k, j + 1);
            list.remove(list.size() - 1);
        }
    }
}
