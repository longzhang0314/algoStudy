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
        // 第k+1小的数索引，并保证过程中左侧所有元素小于第k个
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
        int patition = left;
        for (int i = left; i < right; i++) {
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

    // 方法2：快排过程中生成结果
    public int[] smallestK2(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) return new int[0];
        int[] res = new int[k];
        // 排序过程中填充值
        quickSort(arr, res, k, 0, arr.length - 1, 0);
        return res;
    }

    private void quickSort(int[] arr, int[] res, int k, int left, int right, int cnt) {
        if (left > right || cnt >= res.length) return;
        if (left == right) {
            res[cnt++] = arr[left];
            return;
        }

        // 分割点位置
        int patition = patition2(arr, left, right);
        if (patition - left + 1 == k) {
            for (int i = left; i <= patition; i++) {
                res[cnt++] = arr[i];
            }
            return;
        } else if (patition - left + 1 < k) {
            for (int i = left; i <= patition; i++) {
                res[cnt++] = arr[i];
            }
            quickSort(arr, res, k - (patition - left + 1), patition + 1, right, cnt);
        } else {
            quickSort(arr, res, k, left, patition - 1, cnt);
        }
    }

    private int patition2(int[] arr, int left, int right) {
        int patition = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= arr[right]) {
                int tmp = arr[patition];
                arr[patition] = arr[i];
                arr[i] = tmp;
                patition++;
            }
        }
        int tmp = arr[patition];
        arr[patition] = arr[right];
        arr[right] = tmp;
        return patition;
    }

}
