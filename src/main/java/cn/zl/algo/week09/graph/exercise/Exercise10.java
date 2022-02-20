package cn.zl.algo.week09.graph.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 面试题 17.22. 单词转换（中等）
 *
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 *
 * @author: longzhang
 * @date: 2022/2/20
 */
public class Exercise10 {

    boolean found = false;
    List<String> path = new ArrayList<>();
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || wordList == null || wordList.size() < 2) return new ArrayList<>();
        Set<String> visited = new HashSet<>();
        path.add(beginWord);
        visited.add(beginWord);
        slove(beginWord, endWord, wordList, visited);
        return found ? path : new ArrayList<>();
    }

    private void slove(String begin, String end, List<String> words, Set<String> visited) {
        if (found) return;
        if (begin.equals(end)) {
            found = true;
            return;
        }

        for (int i = 0; i < words.size(); i++) {
            if (visited.contains(words.get(i))) continue;
            if (!isValid(begin, words.get(i))) continue;
            visited.add(words.get(i));
            path.add(words.get(i));
            slove(words.get(i), end, words, visited);
            if (found) return;
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(String a, String b) {
        int i = 0;
        int len = a.length();
        int count = 0;
        while (i < len) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            i++;
        }
        return count == 1;
    }
}
