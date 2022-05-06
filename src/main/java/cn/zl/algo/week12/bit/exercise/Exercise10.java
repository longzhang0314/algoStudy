package cn.zl.algo.week12.bit.exercise;

/**
 * 231. 2 的幂
 *
 * 可优化，只判断1个1就提前结束
 *
 * @author: longzhang
 * @date: 2022/4/5
 */
public class Exercise10 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int cnt = 0;
        int num = 0;
        while (num < 32) {
            if ((n & 1) != 0) {
                cnt++;
            }
            if (cnt == 2) {
                return false;
            }
            n >>= 1;
            num++;
        }
        return cnt == 1;
    }
}
