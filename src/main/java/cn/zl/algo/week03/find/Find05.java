package cn.zl.algo.week03.find;

import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * @author liusha
 * @date 2021/12/17
 */
public class Find05 {

    public static void main(String[] args) {
        Find05 f = new Find05();
        String s = "3[a]2[bc]";
        System.out.println(f.decodeString(s));
    }


    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        int i = 0, n = s.length();
        Stack<String> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        int multi = 0;
        StringBuilder res = new StringBuilder();
        while (i < n) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                multi = multi * 10 + (c - '0');
            } else if (isNormalChar(c)) {
                res.append(c);
            } else if (c == '[') {
                strStack.push(res.toString());
                intStack.push(multi);
                multi = 0;
                res = new StringBuilder();
            } else {
                StringBuilder tmp = new StringBuilder();
                tmp.append(strStack.pop());
                int cnt = intStack.pop();
                for (int j = 0; j < cnt; j++) {
                    tmp.append(res.toString());
                }
                res = tmp;
            }
            i++;
        }
        return res.toString();
    }

    private boolean isNormalChar(char c) {
        return !isDigit(c) && c != '[' && c != ']';
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
