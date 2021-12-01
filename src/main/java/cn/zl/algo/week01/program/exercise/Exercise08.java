package cn.zl.algo.week01.program.exercise;

/**
 * 剑指 Offer 05. 替换空格（简单）
 */
public class Exercise08 {


    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;
        String replace = "%20";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(replace);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
