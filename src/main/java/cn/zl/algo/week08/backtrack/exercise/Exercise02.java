package cn.zl.algo.week08.backtrack.exercise;

/**
 * 37.解数独
 * 【注意】时间优化
 *
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise02 {

    public void solveSudoku(char[][] board) {
        slove(board, 0, 0);
    }

    private boolean slove(char[][] board, int i, int j) {
        if (j == 9) {
            return slove(board, i + 1, 0);
        }
        if (i == 9) {
            return true;
        }

        if (board[i][j] != '.') {
            return slove(board, i, j + 1);
        }

        for (char k = '1'; k <= '9'; k++) {
            if (isValid(board, i, j, k)) {
                board[i][j] = k;
                if (slove(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char target) {
        // 同一行
        for (int m = 0; m < 9; m++) {
            if (m == j) continue;
            if (board[i][m] == target) return false;
        }
        // 同一列
        for (int m = 0; m < 9; m++) {
            if (m == i) continue;
            if (board[m][j] == target) return false;
        }

        // 同一个3*3的框
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                if (i == r && j == c) continue;
                if (board[r][c] == target) return false;
            }
        }

        return true;
    }

    // ==================================== 时间优化 ===================================================

    boolean hasResult = false;
    public void solveSudoku2(char[][] board) {
        boolean[][] rowVisited = new boolean[9][10];
        boolean[][] colVisited = new boolean[9][10];
        boolean[][][] gridVisited = new boolean[3][3][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') continue;
                rowVisited[i][val - '0'] = true;
                colVisited[j][val - '0'] = true;
                // 小格
                gridVisited[i / 3][j / 3][val - '0'] = true;
            }
        }

        slove2(board, rowVisited, colVisited, gridVisited, 0, 0);
    }

    private void slove2(char[][] board, boolean[][] rowVisited, boolean[][] colVisited, boolean[][][] gridVisited, int i, int j) {
        if (hasResult || i == 9) {
            if (i == 9) {
                hasResult = true;
            }
            return;
        }
        if (j == 9) {
            slove2(board, rowVisited, colVisited, gridVisited, i + 1, 0);
            return;
        }

        if (board[i][j] != '.') {
            slove2(board, rowVisited, colVisited, gridVisited, i, j + 1);
            return;
        }

        for (char k = '1'; k <= '9'; k++) {

            boolean rowHas = rowVisited[i][k - '0'];
            boolean colHas = colVisited[j][k - '0'];
            boolean gridHas = gridVisited[i / 3][j / 3][k - '0'];

            if (rowHas || colHas || gridHas) {
                continue;
            }
            board[i][j] = k;
            rowVisited[i][k - '0'] = true;
            colVisited[j][k - '0'] = true;
            gridVisited[i / 3][j / 3][k - '0'] = true;

            slove2(board, rowVisited, colVisited, gridVisited, i, j + 1);
            if (hasResult) return;

            board[i][j] = '.';
            rowVisited[i][k - '0'] = rowHas;
            colVisited[j][k - '0'] = colHas;
            gridVisited[i / 3][j / 3][k - '0'] = gridHas;
        }

    }


}
