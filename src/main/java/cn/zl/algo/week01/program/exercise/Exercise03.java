package cn.zl.algo.week01.program.exercise;

/**
 * 344. 反转字符串（简单）
 * 必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 【注意】可以单指针
 */
public class Exercise03 {

    // 双指针
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int start = 0, end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    // 单指针
    public void reverseString1(char[] s) {
        if (s == null || s.length == 0) return;
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char tmp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = tmp;
        }
    }
}
