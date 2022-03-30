package cn.zl.algo.week12.bit.exercise;

/**
 * 面试题 05.07 配对交换
 *
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 * @author liusha
 * @date 2022/3/29
 */
public class Exercise04 {

    public static void main(String[] args) {
        Exercise04 e = new Exercise04();
        int num = 3;
        System.out.println(e.exchangeBits(num));
    }

    //  1 0 0 1 1 1 res: 0 1 1 0 0 0
    public int exchangeBits(int num) {
        for (int i = 0; i < 31; i += 2) {
            // 奇数位是1 or 0
            boolean odd = ((1 << i) & num) != 0;
            // 偶数位是1 or 0
            boolean even = ((1 << (i + 1)) & num) != 0;
            // 奇数偶数位不同
            if (odd ^ even) {
                if (odd) {
                    // 奇数位是1 -> 0
                    num &= (~(1 << i));
                    num |= (1 << (i + 1));
                } else {
                    // 偶数位是1
                    num &= (~(1 << (i + 1)));
                    num |= (1 << i);
                }
            }
        }
        return num;
    }

}
