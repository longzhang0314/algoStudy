package two.week04.sort;

/**
 * @author liusha
 * @date 2022/8/8
 */
public class Exercise02Test {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] chs = new int[26];
        for (char a : s.toCharArray()) {
            chs[a - 'a']++;
        }
        for (char b : t.toCharArray()) {
            chs[b - 'a']--;
        }
        for (int i = 0; i <= chs.length; i++) {
            if (chs[i] != 0) return false;
        }
        return true;
    }
}
