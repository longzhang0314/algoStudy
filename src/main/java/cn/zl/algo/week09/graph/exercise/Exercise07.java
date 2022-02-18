package cn.zl.algo.week09.graph.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 79.
 *
 * //给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * // 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * //
 * // 示例 1：
 * //输入：board = [["A","B","C","E"],
 *                 ["S","F","C","S"],
 *                 ["A","D","E","E"]], word = "ABCCED"
 * //输出：true
 * //
 * // 示例 3：
 * //输入：board = [["A","B","C","E"],
 *                 ["S","F","C","S"],
 *                 ["A","D","E","E"]], word = "ABCB"
 * //输出：false
 *
 * @author liusha
 * @date 2022/2/18
 */
public class Exercise07 {

    boolean found = false;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && !visited[i][j]) {
                    slove(board, word, visited, i, j, 0);
                    if (found) return true;
                }
            }
        }
        return false;
    }

    private void slove(char[][] board, String word, boolean[][] visited, int i, int j, int idx) {
        if (found) return;
        if (idx == word.length()) {
            found = true;
            return;
        }

        visited[i][j] = true;

        for (int[] direction : directions) {
            int row = i + direction[0];
            int col = j + direction[1];
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) continue;
            if (!visited[row][col] && (idx + 1 == word.length() || word.charAt(idx + 1) == board[row][col])) {
                slove(board, word, visited, row, col, idx + 1);
            }
        }
    }
}
