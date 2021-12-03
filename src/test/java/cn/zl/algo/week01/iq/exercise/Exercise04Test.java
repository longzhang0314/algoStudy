package cn.zl.algo.week01.iq.exercise;

/**
 * @author liusha
 * @date 2021/12/3
 */
public class Exercise04Test {

    public boolean oneEditAway(String first, String second) {
        if (first == null) return second == null;
        if (second == null) return false;

        int len1 = first.length(), len2 = second.length();

        if (Math.abs(len1 - len2) > 2) return false;

        int s1 = 0, s2 = 0;
        int opera = 0;
        while (s1 < len1 && s2 < len2) {
            char f = first.charAt(s1);
            char s = second.charAt(s2);
            if (f == s) {
                s1++;
                s2++;
                continue;
            }
            ++opera;
            if (opera > 1) return false;
            if (len1 < len2) {
                s1++;
            } else if (len1 > len2) {
                s2++;
            } else {
                s1++;
                s2++;
            }

        }
        return true;
    }
}
