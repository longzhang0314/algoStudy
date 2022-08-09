package two.week04.sort;

/**
 * @author liusha
 * @date 2022/8/9
 */
public class Exercise11Test2 {

    // 方法1：quickSort，最终返回第k小作为分割点
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) return new int[0];
        int[] res = new int[k];
        // 第k小的数索引，并保证过程中左侧所有元素小于第k个
        int patition = quickSort(arr, k, 0, arr.length - 1);
        for (int i = 0; i <= patition; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private int quickSort(int[] arr, int k, int left, int right) {
        if (left > right) return -1;
        if (left == right) return left;

        // 分割点索引
        int patition = patition(arr, left, right);

        if (patition - left + 1 == k) {
            return patition;
        } else if (patition - left + 1 < k) {
            return quickSort(arr, k - (patition - left + 1), patition + 1, right);
        } else {
            return quickSort(arr, k, left, patition - 1);
        }
    }

    private int patition(int[] arr, int left, int right) {
        // patition左侧的值全部小于right
        int patition = 0;
        for (int i = 0; i < right; i++) {
            if (arr[i] <= arr[right]) {
                int tmp = arr[i];
                arr[i] = arr[patition];
                arr[patition] = tmp;
                patition++;
            }
        }
        // sqap patition-right
        int tmp = arr[right];
        arr[right] = arr[patition];
        arr[patition] = tmp;
        return patition;
    }

    // =================================  方法分割 =============================================================

    // TODO 继续



}
