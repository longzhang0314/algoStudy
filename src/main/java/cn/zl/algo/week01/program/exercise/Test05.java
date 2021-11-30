package cn.zl.algo.week01.program.exercise;

/**
 * 125. 验证回文串 （简单）
 *
 * 只比较字符大小写，数字，其余直接忽略
 */
public class Test05 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!isCharOrNum(s.charAt(start))) {
                start++;
                continue;
            }
            if (!isCharOrNum(s.charAt(end))) {
                end--;
                continue;
            }
            if (!equalsIgnoreCase(s.charAt(start), s.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }

    private boolean equalsIgnoreCase(char a, char b) {
        String aa = String.valueOf(a);
        String bb = String.valueOf(b);
        return aa.equalsIgnoreCase(bb);
    }

    private boolean isCharOrNum(char c) {
        if (Character.isDigit(c)) return true;
        if (Character.isLetter(c)) return true;
        return false;
    }
}


