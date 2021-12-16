package cn.zl.algo.week03.exercise;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: longzhang
 * @date: 2021/12/16
 */
public class Exercise16Test {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i - k >= deque.peekFirst()) {
                deque.pollFirst();
            }
            if (i - k + 1>= 0) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}


