package cn.zl.algo.week12.bit.exercise;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 *
 * @author: longzhang
 * @date: 2022/4/5
 */
public class Exercise08 {

    public static void main(String[] args) {
        Exercise08 e = new Exercise08();
        // 3: 0 0 1 1; 4: 0 1 0 0
        int[] nums = {3, 4, 3, 3};
        System.out.println(e.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        // 0:最低位
        int[] cnt = new int[32];
        for (int num : nums) {
            int mask = 1;
            if ((num & mask) != 0) {
                cnt[0]++;
            }
            for (int i = 1; i < 32; i++) {
                mask <<= 1;
                if ((num & mask) != 0) {
                    cnt[i]++;
                }
            }
        }
        // 对3求余数
        for (int i = 0; i < 32; i++) {
            cnt[i] %= 3;
        }
        // 恢复
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= cnt[i];
        }
        return res;
    }
}
