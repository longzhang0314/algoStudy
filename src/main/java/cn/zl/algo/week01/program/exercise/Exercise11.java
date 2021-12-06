package cn.zl.algo.week01.program.exercise;

/**
 * 剑指 Offer 67. 把字符串转换成整数（中等）经典atoi()，注意范围越界处理
 *
 * 【注意】经典题目，再练习
 */
public class Exercise11 {

    // 方法1：内部都用正数计算，最后赋值符号位
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

    // ==============================================方法分隔符=============================================================

    // 方法2：数字构造的过程中直接赋值符号位(zheng哥解法)
    public int strToInt2(String str) {
        if (str == null || str.length() == 0) return 0;
        int n = str.length();
        int start = 0;
        while (start < n && str.charAt(start) == ' ') {
            start++;
        }
        if (start == n) return 0;
        int sign = 1;
        if (str.charAt(start) == '+') {
            start++;
        } else if (str.charAt(start) == '-') {
            start++;
            sign = -1;
        }
        int border = Integer.MAX_VALUE / 10;
        int digit = 0;
        while (start < n) {
            char c = str.charAt(start);
            if (!isDigit(c)) break;
            int num = c - '0';
            if (digit > border || digit < -border) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            if (digit == border || digit == -border) {
                if (sign == 1 && num > 7) return Integer.MAX_VALUE;
                else if (sign == - 1 && num > 8) return Integer.MIN_VALUE;
            }
            digit = digit * 10 + sign * num;
            start++;
        }
        return digit;
    }

}
