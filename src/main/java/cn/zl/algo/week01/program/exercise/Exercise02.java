package cn.zl.algo.week01.program.exercise;

/**
 * 1108. IP 地址无效化（简单）
 *
 * 例题2做过，复习一下
 */
public class Exercise02 {

    public String defangIPaddr(String address) {
        if (address == null || address.length() == 0) return address;
        char[] chs = new char[address.length() + 6];
        int idx = 0;
        for (char c : address.toCharArray()) {
            if (c == '.') {
                chs[idx++] = '[';
                chs[idx++] = '.';
                chs[idx++] = ']';
            } else {
                chs[idx++] = c;
            }
        }
        return new String(chs);
    }

    public String defangIPaddr2(String address) {
        if (address == null || address.length() == 0) return address;
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
