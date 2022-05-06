package cn.zl.algo.week12.bit.exercise;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * @author liusha
 * @date 2022/3/31
 */
public class Exercise07 {

    public int[] singleNumbers(int[] nums) {
        // k = a ^ b
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }

        // 分组
        int mask = 1;
        // 找到1个为1的位置，表示这一位a和b是不同的
        while ((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

}
