package cn.zl.algo.week07.heap.exercise;

import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点（中等）
 * @author: longzhang
 * @date: 2022/1/23
 */
public class Exercise04 {

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        // 大顶堆，堆顶是距离原定最远的
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, (a, b) -> isPrior(b, a));
        for (int[] point : points) {
            if (heap.size() < k) {
                heap.offer(point);
            } else if (isPrior(point, heap.peek()) < 0) {
                heap.poll();
                heap.offer(point);
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while (!heap.isEmpty()) {
            res[i++] = heap.poll();
        }
        return res;
    }

    // a 和 b 谁更靠近原定，-1 a, 1 b, 0 相同
    private int isPrior(int[] a, int[] b) {
        int lenA = calc(a);
        int lenB = calc(b);
        return lenA < lenB ? - 1 : lenA > lenB ? 1 : 0;
    }

    private int calc(int[] a) {
        int w = Math.abs(a[0] - 0);
        int h = Math.abs(a[1] - 0);
        return w*w + h*h;
    }
}
