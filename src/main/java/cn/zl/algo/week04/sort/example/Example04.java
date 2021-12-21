package cn.zl.algo.week04.sort.example;

import java.util.Arrays;

/**
 * 排序预处理
 * 有一组无序数据，找出出现次数最多的数据
 * @author: longzhang
 * @date: 2021/12/21
 */
public class Example04 {

    public int maxCount(int[] data) {
        if (data == null || data.length == 0) return 0;
        int prev = -1;
        int count = 0;
        int max = 0;
        Arrays.sort(data);
        for (int i = 0; i < data.length; i++) {
            if (data[i] == prev) {
                count++;
                if (count > max) max = count;
            } else {
                prev = data[i];
                count = 1;
                if (count > max) max = count;
            }
        }
        return max;
    }
}
