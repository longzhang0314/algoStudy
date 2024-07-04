package two.week12.bit;

/**
 * @author 流沙
 * @date 2024/7/4
 */
public class Exercise10Test2 {

    // 231
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        // 从第0位到第31位，仅一个为1即可
        boolean hasOne = false;
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                if (hasOne) return false;
                hasOne = true;
            }
        }
        return hasOne;
    }
}
