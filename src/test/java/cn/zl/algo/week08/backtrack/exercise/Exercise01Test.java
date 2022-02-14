package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2022/2/14
 */
public class Exercise01Test {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] board = new int[n];
        slove(res, board, n, 0);
        return res;
    }

    private void slove(List<List<String>> res, int[] board, int n, int row) {
        if (row == n) {
            List<String> snapshot = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                char[] c = new char[n];
                for (int j = 0; j < n; j++) {
                    c[j] = board[i] == j ? 'Q' : '.';
                }
                snapshot.add(new String(c));
            }
            res.add(snapshot);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row] = col;
                slove(res, board, n, row + 1);
            }
        }
    }

    private boolean isValid(int[] board, int row, int col) {
        int leftUp = col - 1, rightUp = col + 1;
        row--;
        while (row >= 0) {
            if (board[row] == col) return false;
            if (leftUp >= 0 && board[row] == leftUp) return false;
            if (rightUp < board.length && board[row] == rightUp) return false;
            leftUp--;
            rightUp++;
            row--;
        }
        return true;
    }
}
