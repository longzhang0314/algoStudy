package cn.zl.algo.week01.program.exercise;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise07Test {

    // 倒数第k个
    public int lengthOfLastWord(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int cnt = 0;
        int n = len - 1;
        while (n >= 0 && k > 0) {
            if (s.charAt(n) == ' ') {
                n--;
                continue;
            }
            cnt = 0;
            while (n >= 0 && s.charAt(n) != ' ') {
                cnt++;
                n--;
            }
            k--;
        }
        return cnt;
    }
}
