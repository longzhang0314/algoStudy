package cn.zl.algo.week05.hash.exercise;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 49.字母异位词分组（中等）
 *
 * //给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * //
 * // 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * //输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * //
 * //输入: strs = [""]
 * //输出: [[""]]
 * //
 * //输入: strs = ["a"]
 * //输出: [["a"]]
 *
 * // 1 <= strs.length <= 104
 * // 0 <= strs[i].length <= 100
 * // strs[i] 仅包含小写字母
 *
 * TODO 尝试hash表做法，以及hash表存二维数组索引写法训练
 *
 * @author liusha
 * @date 2021/12/30
 */
public class Exercise10 {
    public static void main(String[] args) {
        Exercise10 e = new Exercise10();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(JSON.toJSONString(e.groupAnagrams(strs)));
    }

    // 方法1：暴力对比法
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            boolean hasAna = false;
            for (int j = 0; j < res.size(); j++) {
                if (isAna(res.get(j).get(0), strs[i])) {
                    res.get(j).add(strs[i]);
                    hasAna = true;
                    break;
                }
            }
            if (!hasAna) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                res.add(list);
            }
        }
        return res;
    }

    private boolean isAna(String s1, String s2) {
        if (s1 == null) return s2 == null;
        if (s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        int[] cnt = new int[26];
        for (char c1 : s1.toCharArray()) {
            cnt[c1 - 'a']++;
        }
        for (char c2 : s2.toCharArray()) {
            cnt[c2 - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }
}
