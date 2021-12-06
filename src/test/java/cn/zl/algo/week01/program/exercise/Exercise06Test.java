package cn.zl.algo.week01.program.exercise;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise06Test {

    // 数字转换后比较是否相等
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int origin = x;
        int digit = 0;
        int border = Integer.MAX_VALUE / 10;
        while (x != 0) {
            int change = x % 10;
            if (digit > border) return false;
            if (digit == border && change > 7) return false;
            digit = digit * 10 + change;
            x /= 10;
        }
        return origin == digit;
    }


    // to arr
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int[] arr = new int[10];
        int n = 0;
        while (x != 0) {
            arr[n++] = x % 10;
            x /= 10;
        }
        return valid(arr, 0, n - 1);
    }

    private boolean valid(int[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
