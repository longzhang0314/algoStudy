package two.week05.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liusha
 * @date 2023/4/21
 */
public class Exercise16Test2 {


    public int[] findSwapValues(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) return new int[0];
        // 1:sum odd or even,then sum/2 to sum
        // 2:if array1 and array2 diff is 2a,it need array1+a and array2-a,so diff is even
        // 3:if array1 > array2: array1 everyone example b wait switch,need array2's element is b - a
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int arr1 : array1) {
            sum += arr1;
            sum1 += arr1;
        }
        for (int i = 0; i < array2.length; i++) {
            int arr2 = array2[i];
            sum += arr2;
            sum2 += arr2;
            map.put(arr2, i);
        }
        int diff = sum1 - sum2;
        if ((sum & 1) == 1 || (diff & 1) == 1) return new int[0];
        diff /= 2;
        for (int arr1 : array1) {
            int key = arr1 - diff;
            if (map.containsKey(key)) {
                int[] res = new int[2];
                res[0] = arr1;
                res[1] = key;
                return res;
            }
        }
        return new int[0];
    }
}
