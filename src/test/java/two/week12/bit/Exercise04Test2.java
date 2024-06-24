package two.week12.bit;

/**
 * @author 流沙
 * @date 2024/6/24
 */
public class Exercise04Test2 {


    public int exchangeBits(int num) {
        for (int i = 0; i < 31; i += 2) {
            // 奇数位为1
            boolean odd = (num & (1 << i)) != 0;
            // 偶数位为1
            boolean even = (num & (1 << (i + 1))) != 0;
            // 不同才需要交换
            if (odd ^ even) {
                // 奇数位1 -> 0
                if (odd) {
                    num &= (~(num & (1 << i)));
                    num |= (1 << (i + 1));
                } else {
                    num &= (~(num & (1 << (i + 1))));
                    num |= (1 << i);
                }
            }
        }
        return num;
    }

}
