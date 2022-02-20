package cn.zl.algo.week09.graph.exercise;

/**
 * 1306. 跳跃游戏 III（中等）
 *
 * 这里有一个非负整数数组arr，你最开始位于该数组的起始下标start处。当你位于下标i处时，你可以跳到i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 * @author: longzhang
 * @date: 2022/2/20
 */
public class Exercise08 {

    boolean found = false;
    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length <= start) return false;
        boolean[] visited = new boolean[arr.length];
        slove(arr, start, visited);
        return found;
    }

    private void slove(int[] arr, int start, boolean[] visited) {
        visited[start] = true;
        if (found) return;
        if (arr[start] == 0) {
            found = true;
            return;
        }

        // 往右
        int right = start + arr[start];
        if (right >= 0 && right < arr.length && !visited[right]) {
            slove(arr, right, visited);
            if (found) return;
        }
        // 往左
        int left = start - arr[start];
        if (left >= 0 && left < arr.length && !visited[left]) {
            slove(arr, left, visited);
            if (found) return;
        }
    }

}
