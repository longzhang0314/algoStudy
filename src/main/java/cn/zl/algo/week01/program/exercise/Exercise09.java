package cn.zl.algo.week01.program.exercise;

/**
 * 剑指 Offer 58 - II. 左旋转字符串（简单）
 */
public class Exercise09 {

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     */
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0 || n < 0 || n >= s.length()) return s;
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            // 要放的索引位置，-1表示倒数第一个
            int change = i - n;
            // 转为正数索引
            int idx = change >= 0 ? change : s.length() + change;
            res[idx] = s.charAt(i);
        }
        return new String(res);
    }
}
