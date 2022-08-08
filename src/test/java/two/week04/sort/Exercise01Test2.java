package two.week04.sort;

/**
 * @author liusha
 * @date 2022/8/8
 */
public class Exercise01Test2 {

    public void merge(int[] A, int m, int[] B, int n) {
        int k = m + n - 1;
        int i = m - 1, j = n - 1;
        while (k >= 0 && i >= 0 && j >= 0) {
            if (A[i] <= B[j]) {
                A[k--]= B[j--];
            } else {
                A[k--] = A[i--];
            }
        }

        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}
