package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/15
 */
public class Exercise02Test2 {


    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess == -1) { // 真实值小于mid
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 伪方法，用来调用
    int guess(int num) {
        return -1;
    }
}
