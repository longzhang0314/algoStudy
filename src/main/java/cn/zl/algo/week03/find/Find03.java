package cn.zl.algo.week03.find;

import java.util.Stack;

/**
 * 316. 去除重复字母（中等）
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * @author: longzhang
 * @date: 2021/12/16
 */
public class Find03 {


    public static void main(String[] args) {
        Find03 f = new Find03();
        System.out.println(f.removeDuplicateLetters("bcabc"));
    }

    // TODO 为什么重复元素不能入栈不太好想

    /**
     * - 单调递增栈存储结果
     * - 遇到比栈顶元素小的，判断栈顶元素后面还会不会出现，如果出现，就出栈
     * - 遇到已经入过栈的元素，丢弃当前元素：
     * 	- 证明：当前是c，
     * 	    单调递增栈，第二次遇到c，那么前面肯定有一段xxc；
     * 	    c前面可能是c，丢弃没问题；
     * 	    c前面是b，b无法放入第一段单调递增，说明b前面肯定不是c；
     * 	    c前面是d，那么cd肯定优于dc
     *
     *  分段单调递增，当前出现c，那么前一段也有c；
     *  如果前一段的c是最后一个，cc丢弃；
     *      如果是acbc，或者acac，都不合理
     *  如果前一段的c不是最后一个，cd肯定优于dc
     *
     *  所以第二次出现的c，两种情况：abc c; abcd c 都要被抛弃 (因为这两种不可能出现acb c  aca c)
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        char[] chs = s.toCharArray();
        boolean[] visited = new boolean[26];
        int[] lastIdx = new int[26];
        for (int i = 0; i < n; i++) {
            int idx = chs[i] - 'a';
            lastIdx[idx] = i;
        }

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            char c = chs[i];

            if (visited[c - 'a']) {
                i++;
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && lastIdx[stack.peek() - 'a'] > i) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        char[] res = new char[stack.size()];
        for (int k = res.length - 1; k >= 0; k--) {
            res[k] = stack.pop();
        }
        return new String(res);
    }
}
