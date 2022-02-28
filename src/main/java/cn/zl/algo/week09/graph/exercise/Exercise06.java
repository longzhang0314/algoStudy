package cn.zl.algo.week09.graph.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 207.课程表（中等）
 * <p>
 * //你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * // 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
 * //示如果要学习课程 ai 则 必须 先学习课程 bi 。
 * //
 * // 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * // 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * // 示例 1：
 * //
 * //输入：numCourses = 2, prerequisites = [[1,0]]
 * //输出：true
 * //解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * //
 * // 示例 2：
 * //
 * //输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * //输出：false
 * //解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 *
 * @author liusha
 * @date 2022/2/18
 */
public class Exercise06 {

    public static void main(String[] args) {
        int[][] arr = {{1, 0}};
        int ns = 2;
        Exercise06 e = new Exercise06();
        boolean b = e.canFinish(ns, arr);
        System.out.println(b);
    }

    // 拓扑排序
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        // build graph
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        // 入度
        int[] degree = new int[numCourses];
        for (int[] pre : prerequisites) {
            // pre[1] -> pre[0]
            adj[pre[1]].add(pre[0]);
            degree[pre[0]]++;
        }

        LinkedList<Integer> zeroList = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                zeroList.add(i);
            }
        }

        int zeroCount = 0;
        while (!zeroList.isEmpty()) {
            int cur = zeroList.remove();
            zeroCount++;
            for (int j = 0; j < adj[cur].size(); j++) {
                int k = adj[cur].get(j);
                degree[k]--;
                if (degree[k] == 0) {
                    zeroList.add(k);
                }
            }
        }
        return zeroCount == numCourses;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for (int[] pre : prerequisites) {
            graph.addEdge(pre[1], pre[0]);
        }

        return graph.canFinish();

    }

    private class Graph {
        private int v;
        private LinkedList<Integer>[] adj;
        private int[] degree;

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            this.degree = new int[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) {
            adj[s].add(t);
            degree[t]++;
        }

        public boolean canFinish() {
            LinkedList<Integer> zeroList = new LinkedList<>();

            for (int i = 0; i < degree.length; i++) {
                if (degree[i] == 0) {
                    zeroList.add(i);
                }
            }

            int count = 0;
            while (!zeroList.isEmpty()) {
                int cur = zeroList.remove();
                count++;
                for (int i = 0; i < adj[cur].size(); i++) {
                    int k = adj[cur].get(i);
                    degree[k]--;
                    if (degree[k] == 0) {
                        zeroList.add(k);
                    }
                }
            }

            return count == v;
        }
    }
}
