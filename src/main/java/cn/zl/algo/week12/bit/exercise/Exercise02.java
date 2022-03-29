package cn.zl.algo.week12.bit.exercise;

/**
 * 461. 汉明距离
 *
 * @author liusha
 * @date 2022/3/29
 */
public class Exercise02 {

    public int hammingDistance(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            int a = x & (1 << i);
            int b = y & (1 << i);
            if (a != b) {
                cnt++;
            }
        }
        return cnt;
    }


}
