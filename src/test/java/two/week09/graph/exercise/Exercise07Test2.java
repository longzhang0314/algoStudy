package two.week09.graph.exercise;



/**
 * @author 流沙
 * @date 2023/11/8
 */
public class Exercise07Test2 {

    // 79
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0
                || word == null || word.length() == 0) return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] chs = new char[word.length()];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                chs[0] = board[i][j];
                if (dfs(board, word, visited, m, n, i, j, chs, 0)) return true;
            }
         }
        return false;
    }


    private boolean dfs(char[][] board, String word, boolean[][] visited, int m, int n, int i, int j, char[] chs, int k) {
        if (!isValid(board, visited, m, n, i, j)) return false;
        chs[k] = board[i][j];
        if (chs[k] != word.charAt(k)) return false;
        if (k == chs.length - 1) return true;
        visited[i][j] = true;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (dfs(board, word, visited, m, n, newI, newJ, chs, k + 1)) return true;
        }
        visited[i][j] = false;
        return false;
    }



    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean isValid(char[][] board, boolean[][] visited, int m, int n, int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n && !visited[i][j];
    }

}
