package cn.zl.algo.week01.program.exercise;

/**
 * @author liusha
 * @date 2021/12/3
 */
public class Exercise11Test {

    /**
     * 越界处理：Integer.MAX_VALUE, Integer.MIN_VALUE
     *
     * @param str
     * @return
     */
    public int strToInt1(String str) {
        if (str == null || str.length() == 0) return 0;
        // 去除前导空格
        int start = 0, len = str.length();
        while (start < len) {
            char c = str.charAt(start);
            if (c == ' ') {
                start++;
                continue;
            }
            if (c == '+' || c == '-' || Character.isDigit(c)) break;
            return 0;
        }
        // 判断正负
        boolean ops = true;
        if (str.charAt(start) == '+') {
            start++;
        } else if (str.charAt(start) == '-') {
            start++;
            ops = false;
        }

        // 数字组装
        int digit = 0;
        // 界限
        int border = Integer.MAX_VALUE / 10; // 214748364
        while (start < len) {
            char c = str.charAt(start);
            int num = c - '0';
            if (!Character.isDigit(c)) break;
            if (digit > border) return ops ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (digit == border) {
                if (ops && num > 7) return Integer.MAX_VALUE;
                if (!ops && num > 8) return Integer.MIN_VALUE;
            }
            digit = digit * 10 + num;
            start++;
        }
        return ops ? digit : -digit;
    }


    // 方法一样
    public int strToInt2(String str) {
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
                if (num > 7) return ops ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            digit = digit * 10 + num;
            start++;
        }
        return ops ? digit : -digit;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }


    public static void main(String[] args) {
        Exercise11Test e = new Exercise11Test();
        String s = "4193abc";
        System.out.println(e.strToInt(s));
    }


    // "  -42" 前导空格，符号位
    // "4193abc" 后置非数字字符
    // "abc987" 返回0
    // "-9182838383838" 超过整数范围 返回Integer.MIN_VALUE
    // "" 空字符串 返回0
    // "  " 全文空格 返回0
    public int strToInt(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;

        // 处理空
        if (n == 0) return 0;

        // 处理前置空格
        int i = 0;
        while (i < n && chars[i] == ' ') {
            i++;
        }

        // 全为空格
        if (i == n) return 0;

        // 处理符号
        int sign = 1;
        char c = chars[i];
        if (c == '-') {
            sign = -1;
            i++;
        } else if (c == '+') {
            sign = 1;
            i++;
        }

        // 真正处理数字
        // 整数范围-2147483648~2147483647
        int intAbsHigh = 214748364;
        int result = 0;
        while (i < n && chars[i] >= '0' && chars[i] <= '9') {
            int d = chars[i]-'0';
            // 判断再乘以10，加d之后，是否越界
            if (result < -intAbsHigh || result > intAbsHigh) {
                if (sign==1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            if (result == -intAbsHigh || result == intAbsHigh) {
                if ((sign == 1) && (d > 7)) return Integer.MAX_VALUE;
                if ((sign == -1) && (d > 8)) return Integer.MIN_VALUE;
            }
            // 正常逻辑
            result = result * 10 + sign*d;
            i++;
        }
        return result;
    }
}
