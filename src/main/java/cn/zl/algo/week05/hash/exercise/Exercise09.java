package cn.zl.algo.week05.hash.exercise;

/**
 * 242. 有效的字母异位词(简单)
 *
 *
 * @author liusha
 * @date 2021/12/30
 */
public class Exercise09 {

    public boolean isAnagram(String s, String t) {
        if (s == null) return t == null;
        if (t == null) return false;
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnt[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }

}
