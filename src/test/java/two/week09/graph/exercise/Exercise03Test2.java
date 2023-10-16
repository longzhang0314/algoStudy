package two.week09.graph.exercise;



import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 流沙
 * @date 2023/9/4
 */
public class Exercise03Test2 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start >= n || target >= n || graph == null || graph.length == 0) return false;
        // build graph (邻接矩阵 or 邻接表)
        // method 1: 邻接矩阵
        MyGraph gr = new MyGraph(n);
        for (int[] g : graph) {
            gr.add(g[0], g[1]);
        }
        // find from start to target
        return gr.find(start, target);
    }

    private class MyGraph {

        private int v;
        private LinkedList<Integer>[] adj;
        MyGraph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void add(int s, int t) {
            adj[s].add(t);
        }

        // bfs
        public boolean find(int s, int t) {
            if (s == t) return true;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(s);
            boolean[] visited = new boolean[v];
            visited[s] = true;
            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                if (cur == t) return true;
                for (int next : adj[cur]) {
                    if (visited[next]) continue;
                    queue.offer(next);
                }
            }
            return true;
        }

        boolean found = false;
        boolean[] visited;
        public boolean findDfs(int s, int t) {
            visited = new boolean[v];
            doFindDfs(s, t);
            return found;
        }

        private void doFindDfs(int s, int t) {
            if (s == t) {
                found = true;
                return;
            }
            if (found || visited[s]) {
                return;
            }
            visited[s] = true;
            for (int next : adj[s]) {
                doFindDfs(next, t);
            }
        }

    }
}
