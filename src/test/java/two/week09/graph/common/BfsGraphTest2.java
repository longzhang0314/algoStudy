package two.week09.graph.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 流沙
 * @date 2023/8/14
 */
public class BfsGraphTest2 {

    // 容量
    private int v;
    private LinkedList<Integer>[] adj;

    public BfsGraphTest2(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // s、t：索引
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }


    public boolean bfsSimple(int s, int t) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        queue.offer(s);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (poll == t) return true;
            visited[poll] = true;
            LinkedList<Integer> list = adj[poll];
            for (int child : list) {
                if (visited[child]) continue;
                queue.offer(child);
            }
        }
        return false;
    }


    public void bfs(int s, int t) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        queue.offer(s);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == t) {
                print(prev, s, t);
                return;
            }
            visited[cur] = true;
            LinkedList<Integer> list = adj[cur];
            for (int child : list) {
                if (visited[child]) return;
                prev[child] = cur;
                queue.offer(child);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        // 非起点元素继续递归
        if (prev[t] != s && prev[t] != -1) {
            print(prev, s, prev[t]);
        }
        // 打印完再打印当前元素
        System.out.println(t + " ");
    }


}
