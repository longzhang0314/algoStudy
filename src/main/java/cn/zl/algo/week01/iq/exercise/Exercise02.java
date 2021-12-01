package cn.zl.algo.week01.iq.exercise;

/**
 * 剑指 Offer 61. 扑克牌中的顺子 （中等）
 *
 * 例题2原题，复习一下
 *
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class Exercise02 {

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) return false;
        // [1,2,3,4,5] 顺子最大和最小值差不能大于4
        // 一旦大于4，有0也无法填充
        // 只要最大最小差值小于等于4，且除0以外没有重复值，那么一定能组成顺子
        int min = 100, max = -1;
        boolean[] visited = new boolean[14];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (visited[nums[i]]) return false;
            visited[nums[i]] = true;
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min <= 4;
    }

}
