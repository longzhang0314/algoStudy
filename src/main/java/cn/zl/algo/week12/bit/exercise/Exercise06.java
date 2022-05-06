package cn.zl.algo.week12.bit.exercise;

/**
 * 面试题 17.04 消失的数字
 *
 * 排序、位图、求和、位运算
 *
 * @author liusha
 * @date 2022/3/30
 */
public class Exercise06 {

    // res = res ^ x ^ x
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= n;
        return res;
    }

    // 等差数列：s = a1*n + [n*(n-1)*d] / 2; s =
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = (n + 1) * n / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }



}
