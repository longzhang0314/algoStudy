package two.week12.window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LCR 180. 文件组合
 * @author: longzhang
 * @date: 2024/6/19
 */
public class Exercise01Test2 {

    public static void main(String[] args) {
        Exercise01Test2 e = new Exercise01Test2();
        int[][] ints = e.fileCombination(12);
    }

    // LCR 180. 文件组合
    public int[][] fileCombination(int target) {
        // 题意：和为target的连续正整数数组的所有组合，且每个数组中至少还有两个元素
        // 因为是至少两个连续元素，所以可以从target+1/2开始向左延伸
        // 例如12：:6，11：:6
        // 延伸后如果超了，则最右侧的需要弹出
        if (target < 3) return new int[0][0];
        List<Deque<Integer>> list = new ArrayList<>();
        int rightMax = (target + 1) / 2;
        int curVal = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = rightMax; i >= 1; i--) {
            deque.offerFirst(i);
            curVal += i;
            if (curVal < target) {
                continue;
            }
            if (curVal > target) {
                Integer last = deque.pollLast();
                curVal -= last == null ? 0 : last;
                continue;
            }
            list.add(new ArrayDeque<>(deque));
            Integer last = deque.pollLast();
            curVal -= last == null ? 0 : last;
        }
        if (list.isEmpty()) return new int[0][0];
        int[][] res = new int[list.size()][];
        int k = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            Deque<Integer> de = list.get(i);
            res[k] = new int[de.size()];
            int j = 0;
            while (!de.isEmpty()) {
                res[k][j++] = de.pollFirst();
            }
            k++;
        }
        return res;
    }
}
