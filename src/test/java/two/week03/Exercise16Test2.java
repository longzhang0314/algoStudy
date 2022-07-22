package two.week03;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liusha
 * @date 2022/7/22
 */
public class Exercise16Test2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int c = 0;
        // 单调递减；入队时和队尾比较，队尾小或者相等的直接出、队首超出窗口的直接出
        Deque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 0; i < n; i++) {
            // 已经超出的 比如i是3，那么i<1的需要出队了
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            // 入队
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // i >= k - 1 时开始有结果
            if (i >= k - 1) {
                res[c++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
