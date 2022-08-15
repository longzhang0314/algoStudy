package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/15
 */
public class Exercise03Test2 {


    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                // 大于target，判断是否是大于里面最小的，不是就往左
                if (mid == 0 || letters[mid - 1] <= target) {
                    return letters[mid];
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return letters[0];
    }
}
