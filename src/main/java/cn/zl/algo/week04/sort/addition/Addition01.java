package cn.zl.algo.week04.sort.addition;

import java.util.Arrays;

/**
 * 1122. 数组的相对排序（简单）
 * <p>
 * 给你两个数组，arr1 和arr2，
 * <p>
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2中的元素arr2[i]各不相同
 * arr2 中的每个元素arr2[i]都出现在arr1中
 * <p>
 *
 * @author: longzhang
 * @date: 2021/12/21
 */
public class Addition01 {

    public static void main(String[] args) {
        Addition01 a = new Addition01();
//        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};

        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};
        int[] ints = a.relativeSortArray(arr1, arr2);
        for (int b : ints) {
            System.out.println(b);
        }
    }

    // 计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) return null;
        Arrays.sort(arr1);
        int[] res = new int[arr1.length];
        int[] cnt = new int[1001];
        int k = 0;
        for (int a1 : arr1) {
            cnt[a1]++;
        }
        for (int a2 : arr2) {
            int c = cnt[a2];
            for (int i = 0; i < c; i++) {
                res[k++] = a2;
            }
            cnt[a2] = -1;
        }
        for (int a1 : arr1) {
            if (cnt[a1] != -1) {
                res[k++] = a1;
            }
        }
        return res;
    }


}
