package cn.zl.algo.week01.program.exercise;

/**
 * 9. 回文数（简单）
 *
 * 数字转数组方法； 不用long
 */
public class Exercise06 {

    // 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    // 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
    // 输入：x = 121
    // 输出：true
    // 输入：x = -121
    // 输出：false
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        // 获取反转后的数字，和原数字对比
        // 防止超过int最大值
        long origin = x;
        long target = 0;
        while (x != 0) {
            int val = x % 10;
            target = target * 10 + val;
            x /= 10;
        }
        return origin == target;
    }

    // 不用long，只用int
    public boolean isPalindrome2(int x) {
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
        return digit == origin;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0) return false;
        int[] arr = new int[10];
        int n = 0;
        while (x != 0) {
            arr[n++] = x % 10;
            x /= 10;
        }
        return valid(arr, n);
    }

    private boolean valid(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - i - 1]) return false;
        }
        return true;
    }
}
