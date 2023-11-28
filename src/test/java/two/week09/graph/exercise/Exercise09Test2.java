package two.week09.graph.exercise;

import java.util.*;

/**
 * @author 流沙
 * @date 2023/11/25
 */
public class Exercise09Test2 {

    // 0-9，从0000->target最短次数
    public int openLock(String[] deadends, String target) {
        if (deadends == null) {
            deadends = new String[0];
        }
        // 反之，target->0000的最短次数，路途中不能遇到deadends
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        // 剪枝
        Set<String> visited = new HashSet<>();
        // 思路：四位数，先简化为1位数，一位数有两种转法，转完后进入下一次判断
        // 四位数，则同一时刻有8种选择
        Queue<String> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        int step = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                if ("0000".equals(cur)) {
                    return step;
                }
                // 8种操作
                char[] curChs = cur.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char tmp = curChs[i];
                    // up
                    char plus = plus(tmp);
                    curChs[i] = plus;
                    String up = new String(curChs);
                    if (!deadSet.contains(up) && !visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    // down
                    char minus = minus(tmp);
                    curChs[i] = minus;
                    String down = new String(curChs);
                    if (!deadSet.contains(down) && !visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                    // revoke
                    curChs[i] = tmp;
                }
            }
        }
        return -1;
    }


    private char plus(char c) {
        if (c == '9') return '0';
        return (char) (c + 1);
    }

    private char minus(char c) {
        if (c == '0') return '9';
        return (char) (c - 1);
    }
}
