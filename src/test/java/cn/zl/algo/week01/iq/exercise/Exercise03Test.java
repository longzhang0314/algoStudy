package cn.zl.algo.week01.iq.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2021/12/3
 */
public class Exercise03Test {


    public int[] divingBoard(int shorter, int longer, int k) {
        List<Integer> list = new ArrayList<>();
        // i根长的
        for (int i = 0; i <= k; i++) {
            int len = longer * i + shorter * (k - i);
            if (!list.isEmpty() && list.get(list.size() - 1) == len) continue;
            list.add(len);
        }
        int[] res = new int[list.size()];
        // list to arr
        // ...
        return res;
    }
}
