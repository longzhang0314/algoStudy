package two.week09.graph.common;

import java.util.*;

/**
 * @author 流沙
 * @date 2023/9/4
 */
public class DfsGraph2 {

    private int v;
    private LinkedList<Integer>[] adj;

    public DfsGraph2(int v) {
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

    public List<Integer> dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        List<Integer> res = new ArrayList<>();
        res.add(s);
        visited[s] = true;
        doDfs(res, visited, s, t);
        return res;
    }

    private boolean doDfs(List<Integer> res, boolean[] visited, int cur, int t) {
        if (cur == t) {
            return true;
        }
        LinkedList<Integer> children = adj[cur];
        for (int child : children) {
            if (visited[child]) continue;
            visited[child] = true;
            res.add(child);
            boolean find = doDfs(res, visited, child, t);
            if (find) return true;
            res.remove(res.size() - 1);
            visited[child] = false;
        }
        return false;
    }

    // ========= dfs and print ===========

    boolean found = false;
    public void dfsAndPrint(int s, int t) {
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        doDfsAndPrint(s, t, visited, prev, s);
    }

    private void doDfsAndPrint(int s, int t, boolean[] visited, int[] prev, int originS) {
        if (found) return;
        if (s == t) {
            print(prev, originS, t);
            found = true;
            return;
        }
        visited[s] = true;
        LinkedList<Integer> list = adj[s];
        for (int child : list) {
            if (visited[child]) continue;
            prev[child] = s;
            doDfsAndPrint(child, t, visited, prev, originS);
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != s && prev[t] != -1) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }
}
