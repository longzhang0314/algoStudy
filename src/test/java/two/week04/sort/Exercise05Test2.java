package two.week04.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liusha
 * @date 2022/8/8
 */
public class Exercise05Test2 {


    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        List<int[]> list = new ArrayList<>(intervals.length);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0 ; i < intervals.length; i++) {
            if (list.size() == 0) {
                list.add(intervals[i]);
            } else {
                int[] last = list.get(list.size() - 1);
                if (last[1] >= intervals[i][0]) {
                    last[1] = Math.max(last[1], intervals[i][1]);
                } else {
                    list.add(intervals[i]);
                }
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
