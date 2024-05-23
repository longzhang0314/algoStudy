package cn.zl.algo.week12.prefix.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 05.03 翻转数位
 *
 * // 输入: num = 1775(11011101111)
 * //输出: 8
 * //
 * // 输入: num = 7(01112)
 * //输出: 4
 *
 * TODO do late 重做,新做法
 *
 * 方法1：DP，以当前位置为连续最后一位形成的连续位数量
 * 方法2：暴力找0：没有0，为32；以每个0为中心左右扩展，暴力求解；
 * 方法3：记录每个0的索引数组，遍历该数组，每个0位置找到左右两边的0索引，得出以当前位置为中心0的连续位数量长度
 * 方法4：前缀后缀统计：统计左边和右边1的个数
 *
 * @author liusha
 * @date 2022/3/29
 */
public class Exercise03 {

    public static void main(String[] args) {
        Exercise03 e = new Exercise03();
        int num = 1775;
        System.out.println(e.reverseBits2(num));
    }

    // 方法3
    public int reverseBits2(int num) {
        List<Integer> zeroIdxList = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            boolean isZero = (num & (1 << i)) == 0;
            if (isZero) {
                zeroIdxList.add(i);
            }
        }
        if (zeroIdxList.size() == 0) {
            return 32;
        }

        int max = 1;
        for (int i = 0; i < zeroIdxList.size(); i++) {
            int leftOne = i == 0 ? zeroIdxList.get(i) : zeroIdxList.get(i) - zeroIdxList.get(i - 1) - 1;
            int rightOne = i == zeroIdxList.size() - 1
                    ? 32 - zeroIdxList.get(i) - 1
                    : zeroIdxList.get(i + 1) - zeroIdxList.get(i) - 1;
            max = Math.max(rightOne + leftOne + 1, max);
        }
        return max;
    }

    // 方法1
    public int reverseBits(int num) {
        // 0:不使用替换；1:使用替换
        int[][] dp = new int[32][2];
        dp[0][0] = ((num & 1) == 1) ? 1 : 0;
        dp[0][1] = ((num & 1) == 1) ? -1 : 1;
        for (int i = 1; i < 32; i++) {
            boolean curOne = (num & (1 << i)) != 0;

            if (curOne) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] == -1 ? -1 : dp[i - 1][1] + 1;
            } else {
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < 32; i++) {
            max = Math.max(max, dp[i][0]);
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }


    // 方法4：
    // 在暴力法基础上，提前统计好左右两侧的连续1的个数
    // 统计优化：左侧连续1，且包含当前位；右侧同理
    // 从第0位开始，即为数组最低位
    public int reverseBits4(int num) {
        int[] left = new int[32];
        left[31] = (num & (1 << 31)) == 0 ? 0 : 1;
        for (int i = 30; i >= 0; i--) {
            if ((num & (1 << i)) == 0) {
                continue;
            }
            left[i] = left[i + 1] + 1;
        }
        int[] right = new int[32];
        right[0] = (num & 1) == 0 ? 0 : 1;
        for (int i = 1; i < 32; i++) {
            if ((num & (1 << i)) == 0) {
                continue;
            }
            right[i] = right[i - 1] + 1;
        }

        int max = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                continue;
            }
            int cur = 1
                    + (i < 31 ? left[i + 1] : 0)
                    + (i > 0 ? right[i - 1] : 0);
            max = Math.max(max, cur);
        }
        return max == 0 ? 32 : max;
    }



}
