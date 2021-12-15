package cn.zl.algo.week03.exercise;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值（困难）单调队列
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * @author: longzhang
 * @date: 2021/12/15
 */
public class Exercise16 {

    // 双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(k + 1);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // 从尾部放入
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // i = 3 时，0出队   i - peek >= k
            while (i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            // 第k - 1个数开始就要算滑动窗口最大值了
            if (i >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
