package cn.zl.algo.week04.sort.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间（中等）
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * TODO 重做，按照起始时间排序，按照结束时间排序两种解法
 * @author liusha
 * @date 2021/12/21
 */
public class Exercise05 {


    // [1,5],[2,4],[3,3],[4,8]
    // [3,3],[2,4],[1,5],[4,8]

    // [[2,3],[4,5],[6,7],[8,9],[1,10]]
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        for (int i = intervals.length - 1; i >= 0; i--) {
            int[] interval = intervals[i];
            if (res.size() == 0 || interval[1] < res.get(res.size() - 1)[0]) {
                res.add(interval);
            } else {
                int[] last = res.get(res.size() - 1);
                last[0] = Math.min(last[0], interval[0]);
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        int[][] ans = new int[res.size()][2];
        int i = ans.length - 1;
        for (int[] r : res) {
            ans[i--] = r;
        }
        return ans;
    }

}
