package cn.zl.algo.week01.program.exercise;

/**
 * 剑指 Offer 67. 把字符串转换成整数（中等）经典atoi()，注意范围越界处理
 *
 * 【注意】经典题目，再练习
 */
public class Exercise11 {

    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        // 去除前置空格
        int len = str.length();
        int start = 0;
        while (start < len && str.charAt(start) == ' ') {
            start++;
        }
        if (start == len) return 0;
        // 判断正负
        boolean ops = true;
        if (str.charAt(start) == '+') {
            start++;
        } else if (str.charAt(start) == '-') {
            start++;
            ops = false;
        }
        // digit转换
        int digit = 0;
        int border = Integer.MAX_VALUE / 10;
        while (start < len) {
            char c = str.charAt(start);
            int num = c - '0';
            if (!isDigit(c)) break;
            if (digit > border) return ops ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (digit == border) {
                if (ops && num > 7) return Integer.MAX_VALUE;
                // 此处写>8会溢出，但是奇怪的是力扣上能ac
                if (!ops && num >= 8) return Integer.MIN_VALUE;
            }
            digit = digit * 10 + num;
            start++;
        }
        return ops ? digit : -digit;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }


}
