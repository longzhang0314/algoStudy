package two.week05.hash;

import java.util.*;

/**
 * @author liusha
 * @date 2023/4/11
 */
public class Exercise10Test2 {

    // 方法1：暴力法（每个单词都和已存入res中的单词去比较是否为异位词，是的话add到当前这个内层数组中）O(N^2)
    // 方法2：hash表，key:排序后的字母异位词，value:在二维数组中的索引位置
    // 方法3：hash表，与方法2大致相同，value存储不同，value存储同一个字母异位词的一维数组

    // 全部小写，可为空字符串

    // 方法1
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        for (String str : strs) {
            boolean hasAna = false;
            for (List<String> list : res) {
                if (isAna(list.get(0), str)) {
                    hasAna = true;
                    list.add(str);
                    break;
                }
            }
            if (!hasAna) {
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
            }
        }
        return res;
    }

    private boolean isAna(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        if (c1.length != c2.length) return false;
        int[] cnt = new int[26];
        for (char c : c1) {
            cnt[c - 'a']++;
        }
        for (char c : c2) {
            cnt[c- 'a']--;
        }
        for (int i : cnt) {
            if (i != 0) return false;
        }
        return true;
    }

    // 方法2
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] cc = str.toCharArray();
            Arrays.sort(cc);
            String tmp = new String(cc);
            if (!map.containsKey(tmp)) {
                map.put(tmp, res.size());
                res.add(new ArrayList<>());
            }
            int idx = map.get(tmp);
            res.get(idx).add(str);
        }
        return res;
    }

    // 方法3
    public List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] cc = str.toCharArray();
            Arrays.sort(cc);
            String tmp = new String(cc);
            if (!map.containsKey(tmp)) {
                List<String> list = new ArrayList<>();
                map.put(tmp, list);
                res.add(list);
            }
            map.get(tmp).add(str);
        }
        return res;
    }


}
