package cn.zl.algo.week12.bit.exercise;

/**
 * 191. 位1的个数
 *
 * TODO do 两种方法：第一种：掩码（已做）二：原数右移（无法处理负数）：负数右移空出来的位置补1，可以考虑无符号右移
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
