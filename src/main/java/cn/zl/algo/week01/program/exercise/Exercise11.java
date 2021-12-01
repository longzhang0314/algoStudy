package cn.zl.algo.week01.program.exercise;

/**
 * 剑指 Offer 67. 把字符串转换成整数（中等）经典atoi()，注意范围越界处理
 */
public class Exercise11 {

    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int len = str.length();
        // 去除前置空格
        int start = 0;
        while (start < len) {
            if (str.charAt(start) == '+' || str.charAt(start) == '-' || Character.isDigit(str.charAt(start))) {
                break;
            }
            // 前置是无效位直接返回0
            if (str.charAt(start) != ' ') return 0;
            start++;
        }
        if (start == len) return 0;

        // 判断正负
        boolean positive = true;
        if (str.charAt(start) == '+') {
            start++;
        } else if (str.charAt(start) == '-') {
            start++;
            positive = false;
        }

        // 数字赋值，注意越界判断
        int digit = 0;
        while (start < len) {
            if (!Character.isDigit(str.charAt(start))) break;
            int curNum = str.charAt(start) - '0';
            if (digit > Integer.MAX_VALUE / 10) return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (digit == Integer.MAX_VALUE / 10) {
                if (positive && curNum > 7) {
                    return Integer.MAX_VALUE;
                } else if (!positive && curNum > 8) {
                    return Integer.MIN_VALUE;
                }
            }
            digit = digit * 10 + curNum;
            start++;
        }

        return positive ? digit : -digit;
    }


}
