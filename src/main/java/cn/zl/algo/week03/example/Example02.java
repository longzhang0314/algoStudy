package cn.zl.algo.week03.example;

import java.util.Stack;

/**
 * 删除连续重复字符（腾讯实习）
 *
 * 字符串删除连续的3个重复的字符。比如"abbbc",返回"ac"; "abbbaac",返回"c"。
 * （腾讯 CSIG 22届暑期实习）
 * @author liusha
 * @date 2021/12/13
 */
public class Example02 {

    public String remove(String str) {
        if (str == null) return null;
        Stack<Element> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (stack.isEmpty() || stack.peek().val != c) {
                stack.push(new Element(c, 1));
            } else if (stack.peek().cnt == 2) {
                stack.pop();
            } else {
                stack.peek().cnt++;
            }
        }
        char[] chs = new char[stack.size()];
        for (int i = chs.length - 1; i >= 0; i++) {
            chs[i] = stack.pop().val;
        }
        return new String(chs);
    }

    class Element {
        public char val;
        public int cnt;

        public Element(char val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

    }


}
