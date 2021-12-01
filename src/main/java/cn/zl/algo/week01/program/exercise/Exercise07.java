package cn.zl.algo.week01.program.exercise;

/**
 * TODO 补充题目信息
 */
public class Exercise07 {

    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     * 输入：s = "   fly me   to   the moon  "
     * 输出：4
     *
     * 1 <= s.length <= 104
     * s 仅有英文字母和空格 ' ' 组成
     * s 中至少存在一个单词
     * @param s
     * @return
     */

    // 一次倒序遍历，去除右侧空格，双指针定位长度
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) return 0;
        int start = end - 1;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

}
