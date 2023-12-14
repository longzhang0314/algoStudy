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
    // 由click开始，BFS/DFS
    // 当前位置的赋值逻辑：取决于周围位置雷的个数

    // 题意解析：
    // 从初始点开始，如果初始点就是M，修改为X，结束
    // 否则，当前探索点修改为B,1-8
    // 然后需要分别探讨，如果当前探索点为B，则周围的点都可以放入；如果当前不是B，那么周围的不应该再被探索
    // 重复探索
    // 剪枝：四周8个子位置，探索其中一个子位置时，另外的子位置也可能再次被放入队列，需要剪枝

    public static void main(String[] args) {
        char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = {3, 0};
        Exercise12Test2 e = new Exercise12Test2();
        char[][] chars = e.updateBoard(board, click);
        for (char[] cs : chars) {
            for (char c : cs) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length ==0 || board[0].length == 0) return board;
        if (click == null || click.length == 0) return board;
        int m = board.length, n = board[0].length;
        // 未探索的非雷点
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        boolean[][] visited = new boolean[m][n];
        visited[click[0]][click[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{click[0], click[1]});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            // 当前节点赋值数字，且周围为E的放入队列
            int count = calcM(board, i, j, m, n);
            board[i][j] = count == 0 ? 'B' : (char) (count + '0');
            if (count != 0) continue;
            // 只有周围无雷，周围为E的才可以被下一层探索
            for (int[] direction : directions) {
                int newI = i + direction[0];
                int newJ = j + direction[1];
                if (!inBoard(newI, newJ, m, n)) continue;
                if (visited[newI][newJ]) continue;
                if (board[newI][newJ] == 'E') {
                    queue.offer(new int[]{newI, newJ});
                    visited[newI][newJ] = true;
                }
            }
        }
        return board;
    }

    private int calcM(char[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (!inBoard(newI, newJ, m, n)) continue;
            if (board[newI][newJ] == 'M') count++;
        }
        return count;
    }

    private boolean inBoard(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    // [["E","E","E","E","E"],
    //  ["E","E","M","E","E"],
    //  ["E","E","E","E","E"],
    //  ["E","E","E","E","E"]]

    // 测试
    // [["B","B","B","B","B"],
    //  ["B","1","B","B","B"],
    //  ["B","1","B","B","B"],
    //  ["B","B","B","B","B"]]

    // 期望
    // [["B","1","E","1","B"],
    //  ["B","1","M","1","B"],
    //  ["B","1","1","1","B"],
    //  ["B","B","B","B","B"]]




}
