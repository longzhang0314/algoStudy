package cn.zl.algo.week09.graph.common;

import java.util.LinkedList;

/**
 * 有向无权图
 *
 * @author liusha
 * @date 2022/2/17
 */
public class DirectedGraph {

    /**
     * 临接表实现
     */
    public class Graph1 {
        private int v;
        private boolean[][] matrix;

        public Graph1(int v) {
            this.v = v;
            this.matrix = new boolean[v][v];
        }

        public void addEdge(int s, int t) {
            matrix[s][t] = true;
        }
    }

    /**
     * 临接矩阵实现
     */
    public class Graph2 {
        private int v;
        private LinkedList<Integer>[] matrix;

        public Graph2(int v) {
            this.v = v;
            this.matrix = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                matrix[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) {
            matrix[s].add(t);
        }
    }
}
