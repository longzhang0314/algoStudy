package cn.zl.algo.week01.program.exercise;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序（简单）
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 */
public class Test04 {


    /**
     * 方法1：使用split函数分割字符串，然后对每个字符串前后去空格处理后拼接
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            ss[i] = removeSpace(ss[i]);
            if ("".equals(ss[i])) continue;
            sb.append(ss[i]);
            sb.append(" ");
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
    // 移除单词前后空格
    private String removeSpace(String s) {
        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        int end = s.length() - 1;
        while (end > start && s.charAt(end) == ' ') {
            end--;
        }
        return start > end ? "" : s.substring(start, end + 1);
    }

    // ===============================================  方法分割线 =======================================================

    /**
     * 方法2：倒叙一次遍历法
     *
     * 从后往前遍历，每个单词右边的空格认为是前导空格，左右两边空格包夹的部分是一个单词，一个单词一个单词拼接起来
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        int end = s.length() - 1;
        StringBuilder res = new StringBuilder();
        while (0 <= end) {
            while (0 <= end && s.charAt(end) == ' ') end--;
            if (0 > end) break;
            StringBuilder sb = new StringBuilder();
            while (0 <= end && s.charAt(end) != ' ') {
                sb.append(s.charAt(end));
                end--;
            }
            res.append(sb.reverse());
            res.append(" ");
        }
        return res.length() == 0 ? "" : res.substring(0, res.length() - 1);
    }


    // ===============================================  方法分割线 =======================================================

    /**
     * 方法3：倒序遍历+双指针
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        if (s == null || s.length() == 0) return s;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (end >= 0) {
            // 每个单词去除右边的空格
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            if (end < 0) break;
            // 找到单词的左边界
            int start = end - 1;
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            ++start;
            // 单词放入sb中
            sb.append(s, start, end + 1);
            sb.append(" ");
            // 更新右边界
            end = start - 1;
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }


}
