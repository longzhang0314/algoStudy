package cn.zl.algo.week09.graph.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向无权图BFS
 *
 * @author liusha
 * @date 2022/2/17
 */
public class BfsGraph {

    private int v;
    private LinkedList<Integer>[] adj;

    public BfsGraph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }


    /**
     * 是否有从s到t的路径
     *
     * @param s
     * @param t
     * @return
     */
    public boolean bfsSimple(int s, int t) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == t) return true;

            for (int i = 0; i < adj[cur].size(); i++) {
                int next = adj[cur].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return false;
    }

    /**
     * 打印从s到t的路径
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);
        // 存储每个节点的前置节点
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == t) {
                print(prev, s, t);
                return;
            }

            for (int i = 0; i < adj[s].size(); i++) {
                int next = adj[s].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    prev[next] = cur;
                }
            }
        }
    }

    // 打印s - t，先
    private void print(int[] prev, int s, int t) {
        // 如果不是起点元素，那么先递归打印s - t-1
        if (prev[t] != s && prev[t] != -1) {
            print(prev, s, prev[t]);
        }
        // 最后打印t
        System.out.print(t + " ");
    }
}
