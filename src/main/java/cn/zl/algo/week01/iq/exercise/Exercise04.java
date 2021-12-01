package cn.zl.algo.week01.iq.exercise;

/**
 * 面试题 01.05. 一次编辑（中等）
 *
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 */
public class Exercise04 {

    /**
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     *
     * 输入:
     * first = "pales"
     * second = "pal"
     * 输出: False
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        if (first == null) return second == null;
        if (second == null) return first == null;
        if (Math.abs(first.length() -second.length()) > 1) return false;
        int i = 0, j = 0;
        int operation = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
                continue;
            }
            ++operation;
            if (operation > 1) return false;
            if (first.length() > second.length()) {
                i++;
            } else if (first.length() < second.length()) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
