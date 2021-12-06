package cn.zl.algo.week01.iq.exercise;

/**
 * 面试题 16.04. 井字游戏（中等）
 * TODO 代码较多，再默写一遍; 解法不够优雅，看题解解法
 */
public class Exercise06 {

    public String tictactoe(String[] board) {
        int n = board.length;
        if (n == 1) return board[0].charAt(0) == ' ' ? "Pending" : board[0];
        // 一行，一列，或者两个对角线
        // 存在一种获胜结果，X or O; 两人都未连成，Draw or Pending(有空位)
        boolean hasSpace = false;

        // 同一行是否连成线
        for (int i = 0; i < n; i++) {
            char start = board[i].charAt(0);
            if (start == ' ') {
                hasSpace = true;
                continue;
            }
            for (int j = 1; j < n; j++) {
                char cur = board[i].charAt(j);
                if (cur == ' ') {
                    hasSpace = true;
                    break;
                }
                if (cur != start) break;
                // 第i行有连成线的
                if (j == n - 1) return String.valueOf(cur);
            }
        }

        // 同一列是否连线
        for (int i = 0; i < n; i++) {
            char start = board[0].charAt(i);
            if (start == ' ') {
                hasSpace = true;
                continue;
            }
            for (int j = 1; j < n; j++) {
                char cur = board[j].charAt(i);
                if (cur == ' ') {
                    hasSpace = true;
                    break;
                }
                if (cur != start) break;
                // 第i列有连成线的
                if (j == n - 1) return String.valueOf(cur);
            }
        }

        // 左对角线
        char start = board[0].charAt(n - 1);
        for (int i = 1; i < n; i++) {
            if (start == ' ') {
                hasSpace = true;
                break;
            }
            char cur = board[i].charAt(n - 1 - i);
            if (cur == ' ') {
                hasSpace = true;
                break;
            }
            if (cur != start) break;
            if (i == n - 1) return String.valueOf(cur);
        }

        // 右对角线
        start = board[0].charAt(0);
        for (int i = 1; i < n; i++) {
            if (start == ' ') {
                hasSpace = true;
                break;
            }
            char cur = board[i].charAt(i);
            if (cur == ' ') {
                hasSpace = true;
                break;
            }
            if (cur != start) break;
            if (i == n - 1) return String.valueOf(cur);
        }

        return hasSpace ? "Pending" : "Draw";

    }
}
