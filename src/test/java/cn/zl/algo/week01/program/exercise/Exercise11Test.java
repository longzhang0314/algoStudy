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
    public int strToInt(String str) {
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
}
