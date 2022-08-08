package two.week04.sort;

import cn.zl.algo.week04.sort.exercise.Exercise04;

import java.util.Arrays;

/**
 * @author liusha
 * @date 2022/8/8
 */
public class Exercise04Test {

    public static void main(String[] args) {
        Exercise04 e = new Exercise04();
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println(e.canAttendMeetings(intervals));
        System.out.println(e.canAttendMeetings(intervals2));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }
}
