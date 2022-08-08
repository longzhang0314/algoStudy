package two.week04.sort;

import java.util.Arrays;

/**
 * @author liusha
 * @date 2022/8/8
 */
public class Exercise03Test2 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        Arrays.sort(arr);
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != arr[i - 1] - arr[i - 2]) return false;
        }
        return true;
    }
}
