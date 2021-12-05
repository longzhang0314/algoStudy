package cn.zl.algo.week01.program.exercise;

/**
 * 125. 验证回文串 （简单）
 * 【注意】自己写比较和判断方法
 * 只比较字符大小写，数字，其余直接忽略
 */
public class Exercise05 {

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

    // ======================================== 方法2 =============================================================

    /**
     * 自己通过ASCII码实现比较方法
     * * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        if (s == null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (toLower(s.charAt(i)) != toLower(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    private char toLower(char c) {
        if (c >= '0' && c <= '9') return c;
        if (c >= 'a' && c <= 'z') return c;
        // a 97  A 65  0 48
        // A -> a  +32
        return (char) (c + 32);
    }

    private boolean isLetterOrDigit(char c) {
        if (c >= '0' && c <= '9') return true;
        if (c >= 'a' && c <= 'z') return true;
        if (c >= 'A' && c <= 'Z') return true;
        return false;
    }
}


