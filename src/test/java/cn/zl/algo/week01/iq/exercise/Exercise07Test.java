package cn.zl.algo.week01.iq.exercise;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise07Test {

    public boolean canJump(int[] nums) {
        int maxDepth = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxDepth < i) return false;
            maxDepth = Math.max(maxDepth, i + nums[i]);
        }
        return true;
    }
}
