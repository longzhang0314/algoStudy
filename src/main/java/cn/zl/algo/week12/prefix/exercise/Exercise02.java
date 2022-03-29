package cn.zl.algo.week12.prefix.exercise;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author liusha
 * @date 2022/3/29
 */
public class Exercise02 {

    // 空间O(1)
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int suffixCnt = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffixCnt;
            suffixCnt *= nums[i];
        }
        return res;
    }

    // 前缀、后缀积
    public int[] productExceptSelf1(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        // prefix 不包括自己
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        // suffix
        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // res
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }


}
