package two.week09.graph.exercise;

/**
 *
 * @author 流沙
 * @date 2023/11/17
 */
public class Exercise08Test2 {


    // 这里有一个非负整数数组arr，你最开始位于该数组的起始下标start处。当你位于下标i处时，你可以跳到i + arr[i] 或者 i - arr[i]。
    // *
    // * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
    // *
    // * 注意，不管是什么情况下，你都无法跳到数组之外。
    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0 || start < 0 || start >= arr.length) return false;
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int start, boolean[] visited) {
        if (start < 0 || start >= arr.length || visited[start]) return false;
        if (arr[start] == 0) return true;
        visited[start] = true;
        // jump left or right
        return dfs(arr, start - arr[start], visited)
                || dfs(arr, start + arr[start], visited);
    }
}
