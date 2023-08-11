package two.week08;
/**
 * @author 流沙
 * @date 2023/8/11
 */
public class Exercise02Test2 {


    // // 数字 1-9 在每一行只能出现一次。
    //// 数字 1-9 在每一列只能出现一次。
    //// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
    ////
    ////
    //// 数独部分空格内已填入了数字，空白格用 '.' 表示。
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    slove(board, i, j);
                    return;
                }
            }
        }
    }

    int[][] ops = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean slove(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j == 9) {
            return slove(board, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return slove(board, i, j + 1);
        }

        for (int k = 1; k <= 9; k++) {
            if (valid(board, i, j, k)) {
                board[i][j] = (char) (k + '0');
                if (slove(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean valid(char[][] board, int i, int j, int k) {
        char ck = (char) (k + '0');
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == ck) return false;
        }
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == ck) return false;
        }
        // 3 * 3
        int rowStart = (i / 3) * 3;
        int colStart = (j / 3) * 3;
        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int col = colStart; col < colStart + 3; col++) {
                if (board[row][col] == ck) return false;
            }
        }

        return true;
    }

    // TODO 流沙 方法2 优化
}
