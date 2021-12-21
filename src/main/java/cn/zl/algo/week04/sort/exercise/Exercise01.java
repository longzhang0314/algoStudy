package cn.zl.algo.week04.sort.exercise;

/**
 * 面试题 10.01 合并排序的数组（简单）
 *
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * @author liusha
 * @date 2021/12/21
 */
public class Exercise01 {

    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) return;
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (B[j] >= A[i]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}
