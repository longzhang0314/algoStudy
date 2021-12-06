package cn.zl.algo.week01.program.exercise;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序（简单）
 * <p>
 * 【注意】原地解法 trim方法再写写
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 */
public class Exercise04 {


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
     * <p>
     * 从后往前遍历，每个单词右边的空格认为是前导空格，左右两边空格包夹的部分是一个单词，一个单词一个单词拼接起来
     *
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
     *
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

    // ===============================================  方法分割线 =======================================================

    // the sky is blue
    public static void main(String[] args) {
        Exercise04 e = new Exercise04();
        System.out.println(e.reverseWords4("the sky is blue"));
    }

    /**
     * 方法4：原地翻转两次
     *
     * @param s
     * @return
     */
    public String reverseWords4(String s) {
        if (s == null || s.length() == 0) return s;
        // 如果其他编程语言String可变，那么空间复杂度O(1)
        char[] chs = s.toCharArray();
        // 去除前后空格，以及中间多余的空格，返回新数组长度
        int n = trim(chs);
        reverse(chs, 0, n);
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && chs[j] != ' ') {
                j++;
            }
            reverse(chs, i, j);
            i = j + 1;
        }
        // 此时chs[0,n)其实已经是答案了，后面是返回格式转换
        char[] newChar = new char[n];
        for (int k = 0; k < n; k++) {
            newChar[k] = chs[k];
        }
        return new String(newChar);
    }

    private int trim(char[] chs) {
        int n = chs.length;
        int i = 0;
        while (i < n && chs[i] == ' ') {
            i++;
        }
        int j = n - 1;
        while (j > i && chs[j] == ' ') {
            j--;
        }
        // [i, j]中去除中间空格并且把[i,j]元素搬移到前面
        int k = 0;
        while (i <= j) {
            if (chs[i] == ' ') {
                if (i + 1 <= j && chs[i + 1] != ' ') {
                    chs[k++] = chs[i];
                }
            } else {
                chs[k++] = chs[i];
            }
            i++;
        }
        return k;
    }

    private void reverse(char[] chs, int i, int j) {
        j = j - 1;
        while (i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
    }


}
