package two.week07.heap;

import java.util.PriorityQueue;

public class Exercise04Test2 {

    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0 || k > points.length) return new int[0][0];
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, (a, b) -> -compare(a, b));
        for (int[] point : points) {
            if (heap.size() < k) {
                heap.offer(point);
            } else {
                if (compare(point, heap.peek()) == -1) {
                    heap.poll();
                    heap.offer(point);
                }
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while (!heap.isEmpty()) {
            res[i++] = heap.poll();
        }
        return res;
    }

    private int compare(int[] a, int[] b) {
        long lenA = (long) a[0] * a[0] + (long) a[1] * a[1];
        long lenB = (long) b[0] * b[0] + (long) b[1] * b[1];
        return lenA < lenB ? -1 : lenA > lenB ? 1 : 0;
    }

}
