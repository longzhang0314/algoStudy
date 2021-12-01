package cn.zl.algo.week01.program.example;

/**
 * 判断当前字符串是否是有效的IP地址
 *
 * 4段，由 . 分隔开
 * 可以允许每个数字前后有空格；
 * 数字内部不能有空格；
 * 不能有非数字出现；
 * 数字大小在[0,255]
 */
public class Example01 {

    public static void main(String[] args) {
        Example01 e = new Example01();

        System.out.println(e.isValid("123 . 23 .12 .1"));

        System.out.println(e.isValid("12 3.23. 2. 1  "));
        System.out.println(e.isValid("ab1.1.2. 3 "));
        System.out.println(e.isValid("0.1.256. 1"));
        System.out.println(e.isValid("11.22.3 . 2 3"));
        System.out.println(e.isValid("11. .21.1"));
        System.out.println(e.isValid("123.11.1"));
        System.out.println(e.isValid(null));
        System.out.println(e.isValid(""));
    }


    /**
     * 123 . 23 .12 .1 合法
     *
     * 12 3.23. 2. 1
     * ab1.1.2.3
     * 0.1.256. 1
     * 11.22.3 . 2 3
     * 11. .21.1
     * 123.11.1
     * null or ""
     *
     * @param ipStr
     * @return
     */
    public boolean isValid(String ipStr) {
        if (ipStr == null || ipStr.length() == 0) return false;
        String[] strs = ipStr.split("\\.");
        if (strs.length != 4) return false;
        for (String str : strs) {
            if (!isIpSingle(str)) return false;
        }
        return true;
    }

    private boolean isIpSingle(String str) {
        if (str == null || str.length() == 0) return false;
        int idx = 0;
        // 去除前导空格
        while (idx < str.length() && str.charAt(idx) == ' ') {
            idx++;
        }
        // 全是" "
        if (idx == str.length()) return false;
        // 判断数值是否合理，到" "停止
        int digit = 0;
        for (; idx < str.length() && str.charAt(idx) != ' '; idx++) {
            char c = str.charAt(idx);
            if (c < '0' || c > '9') return false;
            digit = digit * 10 + (c - '0');
            if (digit > 255) return false;
        }
        // 判断是否有" "以外的字符
        while (idx < str.length() && str.charAt(idx) == ' ') {
            idx++;
        }

        return idx == str.length();
    }
}
