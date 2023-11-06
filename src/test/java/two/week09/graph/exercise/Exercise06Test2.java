package two.week09.graph.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: longzhang
 * @date: 2023/11/6
 */
public class Exercise06Test2 {

    public static void main(String[] args) {
        Exercise06Test2 e = new Exercise06Test2();
        int nums = 2;
        int[][] pre = {{1, 0},{0,1}};
        boolean b = e.canFinish(nums, pre);
        System.out.println(b);
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
        // prerequisites中pre[0]依赖pre[1]
        // build graph：
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<>();
        }
        int[] degree = new int[numCourses];
        for (int[] pre : prerequisites) {
            // a -> b代表a先于b执行
            adj[pre[1]].add(pre[0]);
            degree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) queue.offer(i);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res++;
            for (int i = 0 ; i < adj[cur].size(); i++) {
                degree[adj[cur].get(i)]--;
                if (degree[adj[cur].get(i)] == 0) {
                    queue.offer(adj[cur].get(i));
                }
            }
        }
        return res == numCourses;
    }

    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
        // prerequisites中pre[0]依赖pre[1]
        // build graph：
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int[] pre : prerequisites) {
            // a -> b代表a依赖b，b先于a执行
            adj[pre[0]].add(pre[1]);
        }
        // 0 未访问；-1 已被访问过；1 被第二次访问，有环
        visited = new int[numCourses];
        // dfs
        for (int i = 0; i < adj.length; i++) {
            // 有环
            if (!dfs(adj, i)) return false;
        }
        return true;
    }

    private boolean dfs(LinkedList<Integer>[] adj, int i) {
        if (visited[i] == 1) return false;
        if (visited[i] == -1) return true;
        visited[i] = 1;
        for (int j = 0; j < adj[i].size(); j++) {
            if (!dfs(adj, adj[i].get(j))) return false;
        }
        visited[i] = -1;
        return true;
    }
}
