package cn.zl.algo.week05.hash.exercise;

/**
 * 136.只出现一次的数字(简单)
 *
 * //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * // 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * //
 * // 输入: [2,2,1]
 * //输出: 1
 * //
 * // 输入: [4,1,2,1,2]
 * //输出: 4
 *
 * @author liusha
 * @date 2021/12/30
 */
public class Exercise11 {

    // 异或：相同为0，不同为1
    // a ^ b ^ a = a ^ a ^ b = b ^ (全是0的数)
    public int singleNumber(int[] nums) {
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }
}
