package two.week09.graph.exercise;

/**
 * @author 流沙
 * @date 2023/9/4
 */
public class Exercise01Test2 {

    int res = 0;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        // m行n列，不能大于k
        visited = new boolean[m][n];
        process(m, n, k, 0, 0);
        return res;
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void process(int m, int n, int k, int i, int j) {
        if (!isValid(i, j, m, n, k)) {
            return;
        }
        res++;
        visited[i][j] = true;
        for (int[] direction : directions) {
            process(m, n, k, i + direction[0], j+ direction[1]);
        }
    }

    private boolean isValid(int i, int j, int m, int n, int k) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return false;
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }

}
