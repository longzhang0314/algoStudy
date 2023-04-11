package two.week05.hash;

/**
 * @author liusha
 * @date 2023/4/11
 */
public class Exercise13Test2 {

    // 计数：先统计arr1中所有个数；按照arr2顺序取出元素；剩余元素按照正序取出

    // 0 <= arr[i] <= 1000
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int[] res = new int[m];
        int[] cnt = new int[1001];
        for (int a1 : arr1) {
            cnt[a1]++;
        }
        int idx = 0;
        for (int a2 : arr2) {
            int c = cnt[a2];
            for (int i = 0; i < c; i++) {
                res[idx++] = a2;
            }
            cnt[a2] = 0;
        }
        for (int i = 0; i < cnt.length; i++) {
            int c = cnt[i];
            for (int j = 0; j < c; j++) {
                res[idx++] = i;
            }
        }
        return res;
    }
}
