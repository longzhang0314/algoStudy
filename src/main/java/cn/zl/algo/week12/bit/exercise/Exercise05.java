package cn.zl.algo.week12.bit.exercise;

/**
 * 面试题 05.01 插入
 *
 * @author liusha
 * @date 2022/3/30
 */
public class Exercise05 {

    public int insertBits(int N, int M, int i, int j) {
        if (j - i > 31) return N;
        // 1 - 5
        for (int k = 0; k <= j - i; k++) {
            boolean mOne = ((1 << k) & M) != 0;
            if (mOne) {
                // N的第k+i位变为1
                N |= (1 << (k + i));
            } else {
                // N的第k+i位变为0
                N &= (~(1 << (k + i)));
            }
        }
        return N;
    }


}
