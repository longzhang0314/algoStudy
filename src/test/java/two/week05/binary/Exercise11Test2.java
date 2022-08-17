package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/17
 */
public class Exercise11Test2 {

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long mid2 = (long) mid * mid;
            if (num == mid2) {
                return true;
            } else if (num < mid2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
