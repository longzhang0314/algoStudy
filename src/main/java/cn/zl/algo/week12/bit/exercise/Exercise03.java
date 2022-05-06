package cn.zl.algo.week12.bit.exercise;

/**
 * 面试题 05.06 整数转换
 *
 * TODO 也可以先异或，然后判断异或后的结果
 *
 * x ^ -x ：前缀数组那节
 * @author liusha
 * @date 2022/3/29
 */
public class Exercise03 {

    public int convertInteger(int A, int B) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            boolean aOne = (A & (1 << i)) != 0;
            boolean bOne = (B & (1 << i)) != 0;
            if (aOne ^ bOne) {
                cnt++;
            }
        }
        return cnt;
    }

}
