package cn.zl.algo.week08.backtrack.exercise;

/**
 * 37.解数独
 * TODO do 时间优化
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

//    private boolean isValid(char[][] board, int row, int col, char c) {
//        int n = board.length;
//        for (int i = 0; i < n; i++) {
//            if (board[row][i] == c) return false;
//            if (board[i][col] == c) return false;
//            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) return false;
//        }
//        return true;
//    }

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

}
