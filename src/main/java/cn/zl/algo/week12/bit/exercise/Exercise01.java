package cn.zl.algo.week12.bit.exercise;

/**
 * 191. 位1的个数
 * @author liusha
 * @date 2022/3/29
 */
public class Exercise01 {


    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                cnt++;
            }
        }
        return cnt;
    }

}
