package cn.zl.algo.week01.iq.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 16.11. 跳水板（简单）
 *
 * 你正在使用一堆木板建造跳水板。
 * 有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 */
public class Exercise03 {

    /**
     * 输入：
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： [3,4,5,6]
     * 解释：
     * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k <= 0) return new int[]{};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            // i长，k-i短；
            int len = longer * i + shorter * (k - i);
            if (i > 0 && list.get(list.size() - 1) == len) continue;
            list.add(len);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
