package cn.zl.algo.week09.graph.exercise;

import java.util.*;

/**
 * 752.打开转盘锁(中等)（例题）
 *
 * //你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
 * // 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * // 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * // 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * // 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * //
 * // 示例 1:
 * //输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * //输出：6
 * //解释：
 * //可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * //注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * //因为当拨动到 "0102" 时这个锁就会被锁定。
 * //
 * // 示例 2:
 * //输入: deadends = ["8888"], target = "0009"
 * //输出：1
 * //解释：
 * //把最后一位反向旋转一次即可 "0000" -> "0009"。
 * //
 * // 示例 3:
 * //输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * //输出：-1
 * //解释：
 * //无法旋转到目标数字且不被锁定。
 * //
 * // 示例 4:
 * //输入: deadends = ["0000"], target = "8888"
 * //输出：-1
 * //
 * // 提示：
 * // 1 <= deadends.length <= 500
 * // deadends[i].length == 4
 * // target.length == 4
 * // target 不在 deadends 之中
 * // target 和 deadends[i] 仅由若干位数字组成
 *
 *
 * 注意：这题不能用DFS，因为用visited去重会导致把后续Path更短的给去重掉，保留了路径更长的。
 *
 * @author liusha
 * @date 2022/2/17
 */
public class Exercise09 {

    public static void main(String[] args) {
        Exercise09 e = new Exercise09();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int i = e.openLock(deadends, target);
        System.out.println(i);
    }



    // BFS：最短路径问题用BFS
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        if (deadends != null) {
            deadSet.addAll(Arrays.asList(deadends));
        }
        if (deadSet.contains("0000")) return -1;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(target);
        visited.add(target);

        int step = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals("0000")) {
                    return step;
                }
                // 8种选择
                char[] curChs = cur.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char origin = curChs[j];
                    // up
                    curChs[j] = plusOne(origin);
                    String next = new String(curChs);
                    if (!visited.contains(next) && !deadSet.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                    // down
                    curChs[j] = minusOne(origin);
                    next = new String(curChs);
                    if (!visited.contains(next) && !deadSet.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }

                    curChs[j] = origin;
                }
            }
        }
        return -1;
    }





    // 方法2：DFS（本题不使用，答案是错的，因为DFS不能保证先访问到更短的路径，visited数组会把后访问到的更短路径过滤掉）

    // 题意转换，target转到0000
    int min = Integer.MAX_VALUE;
    public int openLock2(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        if (deadends != null) {
            deadSet.addAll(Arrays.asList(deadends));
        }
        if (deadSet.contains("0000")) return -1;
        Set<String> visited = new HashSet<>();
        char[] chs = target.toCharArray();
        slove(chs, deadSet, visited, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void slove(char[] chs, Set<String> deadSet, Set<String> visited, int path) {
        visited.add(new String(chs));
        if (deadSet.contains(new String(chs))) {
            return;
        }
        if ("0000".equals(new String(chs))) {
            min = Math.min(path, min);
            return;
        }
        // 8种选择
        for (int i = 0; i < 4; i++) {
            // 每个位置plus或者minus
            // plus
            char origin = chs[i];
            chs[i] = plusOne(origin);
            if (!visited.contains(new String(chs))) {
                slove(chs, deadSet, visited, path + 1);
            }
            chs[i] = origin;
            // minus
            origin = chs[i];
            chs[i] = minusOne(origin);
            if (!visited.contains(new String(chs))) {
                slove(chs, deadSet, visited, path + 1);
            }
            chs[i] = origin;
        }

    }


    private char plusOne(char num) {
        if (num == '9') return '0';
        return (char) (num + 1);
    }

    private char minusOne(char num) {
        if (num == '0') return '9';
        return (char) (num - 1);
    }

}
