package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/17
 */
public class Exercise12Test2 {

    public int mySqrt(int x) {
        if (x < 0) return -1;
        int left = 0, right = x / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long mid2 = (long) mid * mid;
            if (mid2 == x) {
                return mid;
            } else if (mid2 < x && (long) (mid + 1) * (mid + 1) > x) {
                return mid;
            } else if (mid2 < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
