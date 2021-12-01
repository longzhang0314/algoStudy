package cn.zl.algo.week01.program.exercise;

/**
 * @author liusha
 * @date 2021/12/1
 */
public class Exercise04Test {

    // 1. split + remove word space
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

    // 2. reverse while loop and double pointer
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0) {
            // remove precursor space（right of end space）
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            int start = end;
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            ++start;
            // [start,end] is a word
            sb.append(s, start, end + 1);
            sb.append(" ");
            end = start - 1;
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }


}
