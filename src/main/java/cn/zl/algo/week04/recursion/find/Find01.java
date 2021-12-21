package cn.zl.algo.week04.recursion.find;

/**
 * 正则表达式匹配（困难）
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *
 * @author liusha
 * @date 2021/12/20
 */
public class Find01 {

    public static void main(String[] args) {
        Find01 f = new Find01();
        System.out.println(f.isMatch("aa", "a"));                   // false
        System.out.println(f.isMatch("aa", "a*"));                  // true
        System.out.println(f.isMatch("ab", ".*"));                  // true
        System.out.println(f.isMatch("aab", "c*a*b"));              // true
        System.out.println(f.isMatch("mississippi", "mis*is*p*.")); // false
    }


    /**
     * 提示：
     *
     *  1 <= s.length <= 20
     *  1 <= p.length <= 30
     *  s 可能为空，且只包含从 a-z 的小写字母。
     *  p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。【只有p包含.和*】
     *  保证每次出现字符 * 时，前面都匹配到有效的字符
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null) return p == null;
        if (p == null) return false;
        int i = 0, j = 0, n1 = s.length(), n2 = p.length();
        char[] c1 = s.toCharArray(), c2 = p.toCharArray();
        return isMatch(c1, i, n1, c2, j, n2);
    }

    private boolean isMatch(char[] c1, int i, int n1, char[] c2, int j, int n2) {
        // TODO 多种解法

        return false;
    }
}
