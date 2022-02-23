package cn.zl.algo.week09.graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题.04.01. 节点间通路
 * TODO 邻接表写法，但不需要真的建一个Graph class
 * @author liusha
 * @date 2022/2/17
 */
public class Exercise03 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Graph realGraph = new Graph(n);
        for (int[] num : graph) {
            realGraph.addEdge(num);
        }
        return realGraph.dfs(start, target);
    }

    private class Graph {
        int v;
        LinkedList<Integer>[] adj;

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int[] num) {
            adj[num[0]].add(num[1]);
        }

        boolean found = false;
        public boolean dfs(int start, int end) {
            boolean[] visited = new boolean[v];
            slove(visited, start, end);
            return found;
        }

        private void slove(boolean[] visited, int start, int end) {
            if (found || visited[start]) return;
            if (start == end) {
                found = true;
                return;
            }
            visited[start] = true;
            for (int i = 0; i < adj[start].size(); i++) {
                int next = adj[start].get(i);
                slove(visited, next, end);
            }

        }

        public boolean bfs(int start, int end) {
            boolean[] visited = new boolean[v];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                visited[cur] = true;
                if (cur == end) return true;

                for (int i = 0; i < adj[cur].size(); i++) {
                    int next = adj[cur].get(i);
                    if (!visited[next]) {
                        queue.offer(next);
                    }
                }
            }

            return false;
        }
    }
}
