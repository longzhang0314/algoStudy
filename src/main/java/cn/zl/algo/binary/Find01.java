package cn.zl.algo.binary;

import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第 K 小的元素
 *
 * 给你一个n x n矩阵matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 *
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 *
 * 提示：
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n2
 *
 * @author: longzhang
 * @date: 2021/12/25
 */
public class Find01 {

    public static void main(String[] args) {
        Find01 f = new Find01();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(f.kthSmallest(matrix, k));
    }


    // 方法1：二分
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == -1 || k <= 0 || k > matrix.length * matrix.length) return -1;
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // -1: 小于mid的元素大于等于k个
            // 0： 小于mid的元素小于k个，大于mid的元素小于等于n*n - k
            // 1:  小于mid的元素小于k个
            int ops = ops(matrix, mid, k, n);
            if (ops == 0) {
                return mid;
            } else if (ops == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int ops(int[][] matrix, int mid, int k, int n) {
        // 小于mid的元素
        int cnt = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            int cur = matrix[i][j];
            if (cur < mid) {
                cnt += i + 1;
                j++;
            } else {
                i--;
            }
        }
        if (cnt >= k) return -1;

        // 大于mid的元素
        i = 0;
        j = n - 1;
        int cnt1 = 0;
        while (i < n && j >= 0) {
            int cur = matrix[i][j];
            if (cur > mid) {
                cnt1 += n - i;
                j--;
            } else {
                i++;
            }
        }
        if (cnt1 <= n * n - k) return 0;
        return 1;
    }



    // 方法2：堆排序，求第k小，那么用容量为k的大顶堆，存储最小的k个数（效率不高）
    public int kthSmallest1(int[][] matrix, int k) {
        if (matrix == null || matrix.length == -1 || k <= 0 || k > matrix.length * matrix.length) return -1;
        int n = matrix.length;
        // 存储k个元素的大顶堆（存储最小的k个数，堆顶即为第k小）
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (heap.size() < k) {
                    heap.offer(num);
                } else {
                    if (heap.peek() > num) {
                        heap.poll();
                        heap.offer(num);
                    }
                }
            }
        }
        return heap.peek();
    }
}
