package cn.zl.algo.week01.program.exercise;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise05Test {

    // 只比较字符大小写，数字，其余直接忽略
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            if (!isDigitOrLetter(chs[i])) {
                i++;
                continue;
            }
            if (!isDigitOrLetter(chs[j])) {
                j--;
                continue;
            }
            if (toLower(chs[i]) != toLower(chs[j])) {
                return false;
            }
            i++;
            j--;
        }
        return false;
    }

    private char toLower(char c) {
        // a97 A65 0 48
        if (c >= 'a' && c <= 'z') return c;
        if (c >= '0' && c <= '9') return c;
        return (char) (c + 32);
    }

    private boolean isDigitOrLetter(char c) {
        if (c >= 'a' && c <= 'z') return true;
        if (c >= 'A' && c <= 'Z') return true;
        if (c >= '0' && c <= '9') return true;
        return false;
    }
}
