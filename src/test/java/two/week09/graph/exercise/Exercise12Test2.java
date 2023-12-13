package two.week09.graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 流沙
 * @date 2023/12/6
 */
public class Exercise12Test2 {

    // //输入：board = [["E","E","E","E","E"],
    //                 ["E","E","M","E","E"],
    //                 ["E","E","E","E","E"],
    //                 ["E","E","E","E","E"]],
    //       click = [3,0]
    ////输出：         [["B","1","E","1","B"],
    //                 ["B","1","M","1","B"]
    //                 ["B","1","1","1","B"],
    //                 ["B","B","B","B","B"]]

    // M:地雷未探索，E:空白未探索，X：地雷已探索，B：空白且周围都是空白，1-8：空白且周围有1-8个雷
    // 由click开始，BFS
    // 当前位置的赋值逻辑：取决于周围位置雷的个数
    // 不需要visited，非ME本身都是visited
    // 如何判断是雷，M
    // 遇到X终止
    // 直接修改board即可
    // 图遍历，剪枝思路？
    // 与普通图遍历区别：遍历到当前位置时，需要知道周围8个位置有多少雷，如何在不遍历8个位置的情况知道当前位置周围的雷？好像没办法，只能遍历，减少遍历次数

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length ==0 || board[0].length == 0) return board;
        if (click == null || click.length == 0) return board;
        int m = board.length, n = board[0].length;
        // 存放未探索的
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{click[0], click[1]});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            if (board[i][j] == 'M') {
                board[i][j] = 'X';
                return board;
            }
            int count = 0;
            // 遍历、计算count、并放入queue
            for (int[] direction : directions) {
                int newI = i + direction[0];
                int newJ = j + direction[1];
                if (!inBoard(newI, newJ, m, n)) continue;
                if (board[newI][newJ] == 'M') {
                    count++;
                }
                if (board[newI][newJ] == 'M' || board[newI][newJ] == 'E') {
                    queue.offer(new int[]{newI, newJ});
                }
            }
            // 根据count赋值board[i][j]
            board[i][j] = count == 0 ? 'B' : (char) (count + '0');
        }
        return board;
    }

    private boolean inBoard(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }


}
