package cn.zl.algo.week09.graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 529. 扫雷游戏（困难）
 *
 * TODO BFS超时
 *
 *
 * @author liusha
 * @date 2022/2/21
 */
public class Exercise12 {


    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
//        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{click[0], click[1]});

        // 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X' 。
// 如果一个 没有相邻地雷 的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的 未挖出 方块都应该被递归地揭露。
// 如果一个 至少与一个地雷相邻 的空方块（'E'）被挖出，修改它为数字（'1' 到 '8' ），表示相邻地雷的数量。
// 如果在此次点击中，若无更多方块可被揭露，则返回盘面。

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                // deal
                int x = arr[0];
                int y = arr[1];
                char c = board[x][y];
                if (c == 'M') {
                    board[x][y] = 'X';
                    return board;
                }
                int count = calc(board, x, y);
                if (count == 0) {
                    board[x][y] = 'B';
                    // expand
                    for (int[] direction : directions) {
                        int newX = x + direction[0];
                        int newY = y + direction[1];
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == 'E') {
                            queue.offer(new int[]{newX, newY});
                        }
                    }
                } else {
                    board[x][y] = (char) (count + '0');
                }
            }
        }
        return board;
    }

    private int calc(char[][] board, int x, int y) {
        int count = 0;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'M') {
                count++;
            }
        }
        return count;
    }
}
