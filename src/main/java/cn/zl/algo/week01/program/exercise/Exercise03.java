package cn.zl.algo.week01.program.exercise;

/**
 * 344. 反转字符串（简单）
 *
 * 必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Exercise03 {

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
}
