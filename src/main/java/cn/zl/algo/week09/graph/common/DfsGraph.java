package cn.zl.algo.week09.graph.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liusha
 * @date 2022/2/17
 */
public class DfsGraph {

    private int v;
    private LinkedList<Integer>[] adj;

    public DfsGraph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[v] = new LinkedList<>();
        }
    }

    boolean found = false;
    public boolean dfsSimple(int s,int t) {
        boolean[] visited = new boolean[v];
        visited[s] = true;
        dfsSimple(s, t, visited);
        return found;

    }

    private void dfsSimple(int s, int t, boolean[] visited) {
        if (found) return;
        if (s == t) {
            found = true;
            return;
        }

        for (int i = 0; i < adj[s].size(); i++) {
            int next = adj[s].get(i);
            if (!visited[next]) {
                visited[next] = true;
                dfsSimple(next, t, visited);
            }
        }
    }

    // ============================

    boolean found2 = false;
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        dfs(s, t, visited, prev);
    }

    private void dfs(int s, int t, boolean[] visited, int[] prev) {
        if (found2) return;
        visited[s] = true;
        if (s == t) {
            found2 = true;
            print(prev, s, t);
            return;
        }

        for (int i = 0; i < adj[s].size(); i++) {
            int next = adj[s].get(i);
            if (!visited[next]) {
                prev[next] = s;
                dfs(s, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && prev[t] != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    // ==============================

    List<List<Integer>> res;
    public List<List<Integer>> dfs2(int s, int t) {
        res = new ArrayList<>();
        boolean[] visited = new boolean[v];
        List<Integer> path = new ArrayList<>();
        dfs2(s, t, visited, path);
        return res;
    }

    private void dfs2(int s, int t, boolean[] visited, List<Integer> path) {
        if (s == t) {
            res.add(new ArrayList<>(path));
            return;
        }

        visited[s] = true;
        path.add(s);

        for (int i = 0; i < adj[s].size(); i++) {
            int next = adj[s].get(i);
            if (!visited[next]) {
                dfs2(s, t, visited, path);
            }
        }

        path.remove(path.size() - 1);
    }
}
