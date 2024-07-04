package two.week12.bit;

/**
 * @author 流沙
 * @date 2024/6/27
 */
public class Exercise07Test2 {

    public int[] singleNumbers(int[] nums) {
        // 0 ^ x = x
        // k = a ^ b
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }
        // find any a and b diff bit
        // if k bit = 1, this bit a and b diff
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            // 与mask所在bit位是否为1，拆分两组，则a、b一定属于不同组
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

}
