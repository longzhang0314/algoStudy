package cn.zl.algo.week01.program.exercise;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise03Test {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char tmp = s[i];
            s[i] = s[n - i -1];
            s[n - i - 1] = tmp;
        }
    }
}
