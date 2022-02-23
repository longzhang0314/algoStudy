package cn.zl.algo.week09.graph.exercise;

import java.util.PriorityQueue;

/**
 * 面试题.16.19. 水域大小
 *
 * //你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指
 * //相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * // 示例：
 * // 输入：
 * //[
 * //  [0,2,1,0],
 * //  [0,1,0,1],
 * //  [1,1,0,1],
 * //  [0,1,0,1]
 * //]
 * //输出： [1,2,4]
 *
 * @author liusha
 * @date 2022/2/17
 */
public class Exercise05 {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};
    int count = 0;
    public int[] pondSizes(int[][] land) {
        int m = land.length, n = land[0].length;
        // TODO 可以把值改为0代替visited
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    dfs(land, i, j, visited);
                    heap.offer(count);
                    count = 0;
                }
            }
        }
        int[] res = new int[heap.size()];
        int i = 0;
        while (!heap.isEmpty()) {
            res[i++] = heap.poll();
        }
        return res;
    }

    private void dfs(int[][] land, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        count++;
        for (int[] direction : directions) {
            int row = i + direction[0];
            int col = j + direction[1];
            if (row < 0 || row >= land.length || col < 0 || col >= land[0].length) continue;
            if (visited[row][col] || land[row][col] != 0) continue;
            dfs(land, row, col, visited);
        }
    }

}
