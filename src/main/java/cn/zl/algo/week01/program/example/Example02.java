package cn.zl.algo.week01.program.example;

/**
 * IP地址无效化
 *
 * 12.2.3.1 转化为 12[.]2[.]3[.]1
 *
 * @author liusha
 * @date 2021/11/30
 */
public class Example02 {

    public static void main(String[] args) {
        Example02 e = new Example02();
        System.out.println(e.invalidStr("12.2.3.1"));
    }

    public String invalidStr(String ipStr) {
        if (ipStr == null || ipStr.length() == 0) return ipStr;
        char[] res = new char[ipStr.length() + 6];
        int idx = 0;
        for (char c : ipStr.toCharArray()) {
            if (c == '.') {
                res[idx++] = '[';
                res[idx++] = '.';
                res[idx++] = ']';
            } else {
                res[idx++] = c;
            }
        }
        return new String(res);
    }
}
