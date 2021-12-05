package cn.zl.algo.week01.program.exercise;

/**
 * 剑指 Offer 58 - II. 左旋转字符串（简单）
 *
 * 【注意】3种解法：空间O(N)、空间O(K)、空间O(1)(但是时间O(KN))
 */
public class Exercise09 {

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     *
     * 方法1：旋转后新的索引赋值道新的数组中; 也可以先放[k, len), 再放[0, k)
     *
     * 空间O(N)
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

    /**
     * 方法2：长度为K的临时数组放置前K个数
     * 空间O(K)
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        if (s == null || s.length() == 0 || n < 0 || n >= s.length()) return s;
        char[] chs = s.toCharArray();
        int len = chs.length;
        char[] tmp = new char[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = chs[i];
        }

        int k = 0;
        int i = n;
        while (i < len) {
            chs[k++] = chs[i++];
        }
        for (int j = 0; j < n; j++) {
            chs[k++] = tmp[j];
        }
        return new String(chs);
    }

    /**
     * 方法3：临时存储最左边元素
     *
     * 空间O(1),时间O(NK)：不推荐
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords3(String s, int n) {
        if (s == null || s.length() == 0 || n < 0 || n >= s.length()) return s;
        char[] chs = s.toCharArray();
        int len = chs.length;
        char tmp = chs[0];
        while (n > 0) {
            // 每次左移一位
            for (int i = 1; i < len; i++) {
                chs[i - 1] = chs[i];
            }
            chs[len - 1] = tmp;
            tmp = chs[0];
            n--;
        }
        return new String(chs);
    }
}
