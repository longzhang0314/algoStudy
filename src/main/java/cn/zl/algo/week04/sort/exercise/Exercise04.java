package cn.zl.algo.week04.sort.exercise;

import java.util.Arrays;

/**
 * 252.会议室（简单）（会员
 *
 * 给定一个会议时间安排的数组intervals，每个会议时间都包括开始和结束时间intervals[i]=[start_i, end_i]，
 * 请你判断一个人是否能够参加参加这里面的全部会议。
 *
 * 输入: invervals=[[0,30],[5,10],[15,20]]
 * 输出: false
 *
 * 输入: invervals=[[7,10],[2,4]]
 * 输出: true
 *
 * @author liusha
 * @date 2021/12/21
 */
public class Exercise04 {

    public static void main(String[] args) {
        Exercise04 e = new Exercise04();
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println(e.canAttendMeetings(intervals));
        System.out.println(e.canAttendMeetings(intervals2));
    }


    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }


}
