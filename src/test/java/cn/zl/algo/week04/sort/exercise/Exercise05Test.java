package cn.zl.algo.week04.sort.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liusha
 * @date 2021/12/27
 */
public class Exercise05Test {


    // 开始区间排序
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int curL = intervals[0][0], curR = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= curR) {
                curR = Math.max(curR, interval[1]);
            } else {
                res.add(new int[]{curL, curR});
                curL = interval[0];
                curR = interval[1];
            }
        }
        res.add(new int[]{curL, curR});
        return res.toArray(new int[intervals.length][]);
    }

    // 结尾区间排序
    public int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = intervals.length;
        int curL = intervals[n - 1][0], curR = intervals[n - 1][1];
        for (int i = n - 2; i >= 0; i--) {
            int[] interval = intervals[i];
            if (interval[1] >= curL) {
                curL = Math.min(curL, interval[0]);
            } else {
                res.add(new int[]{curL, curR});
                curL = interval[0];
                curR = interval[1];
            }
        }
        res.add(new int[]{curL, curR});
        return res.toArray(new int[n][]);
    }
}
