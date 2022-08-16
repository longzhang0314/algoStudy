package two.week05.binary;


/**
 * @author liusha
 * @date 2022/8/16
 */
public class Exercise09Test {

    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[(mid - 1 + arr.length) % arr.length]
                    && arr[mid] > arr[(mid + 1) % arr.length]) {
                return mid;
            }

            if (mid == 0) {
                left = mid + 1;
            } else if (mid == arr.length - 1) {
                right = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
