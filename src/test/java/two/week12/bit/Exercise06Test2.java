package two.week12.bit;

/**
 * @author 流沙
 * @date 2024/6/25
 */
public class Exercise06Test2 {

    // 从0到n：缺了一个，找到
    // ^ :相同为0；不同为1；任何值与0异或等于其本身
    // 方法1：异或
    public int missingNumber1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;
        return res;
    }

    // 方法2：等差数列之和，减去数组中的和
    public int missingNumber2(int[] nums) {
        // 1-n的和
        int n = nums.length;
        boolean odd = (n & 1) != 0;
        int sum = n + n * (n - 1) / 2;
        // a1*n + n(n-1)d/2
        for (int i = 0; i < n ; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
