package two.week09.graph.exercise;

import java.util.*;

/**
 * @author 流沙
 * @date 2023/9/13
 */
public class Exercise05Test2 {


    //你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指
    //相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
    // 示例：
    // 输入：
    //[
    //  [0,2,1,0],
    //  [0,1,0,1],
    //  [1,1,0,1],
    //  [0,1,0,1]
    //]
    //输出： [1,2,4]
    //
    // 提示：
    //
    // 0 < len(land) <= 1000
    // 0 < len(land[i]) <= 1000
    // 按照8个方向
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    // 方法1：dfs
    public int[] pondSizes2(int[][] land) {
        if (land == null || land.length == 0 || land[0].length == 0) return new int[0];
        PriorityQueue<Integer> cntHeap = new PriorityQueue<>();
        int m = land.length, n = land[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    int cnt = dfs(land, visited, m, n, i, j);
                    cntHeap.offer(cnt);
                }
            }
        }
        int[] res = new int[cntHeap.size()];
        int i = 0;
        while (!cntHeap.isEmpty()) {
            res[i++] = cntHeap.poll();
        }
        return res;
    }

    private int dfs(int[][] land, boolean[][] visited, int m, int n, int i, int j) {
        if (!isValid(land, visited, m, n, i, j)) {
            return 0;
        }
        visited[i][j] = true;
        int res = 1;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            res += dfs(land, visited, m, n, newI, newJ);
        }
        return res;
    }

    private boolean isValid(int[][] land, boolean[][] visited, int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n && land[i][j] == 0 && !visited[i][j];
    }



    // 方法2：bfs
    public int[] pondSizes(int[][] land) {
        if (land == null || land.length == 0 || land[0].length == 0) return new int[0];
        PriorityQueue<Integer> cntHeap = new PriorityQueue<>();
        int m = land.length, n = land[0].length;
        boolean[][] visited = new boolean[m][n];
        // travel
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int cnt = 0;

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        cnt++;
                        for (int[] direction : directions) {
                            int newI = poll[0] + direction[0];
                            int newJ = poll[1] + direction[1];
                            if (!isValid(land, visited, m, n, newI, newJ)) continue;
                            queue.offer(new int[]{newI, newJ});
                            visited[newI][newJ] = true;
                        }
                    }

                    cntHeap.offer(cnt);
                }
            }
        }

        int[] res = new int[cntHeap.size()];
        int i = 0;
        while (!cntHeap.isEmpty()) {
            res[i++] = cntHeap.poll();
        }
        return res;
    }


}
