package cn.zl.algo.week09.graph.exercise;

import java.util.*;

/**
 * 126. 单词接龙 II（困难）
 *
 *
 *
 * TODO do 超时
 *
 * @author liusha
 * @date 2022/2/21
 */
public class Exercise14 {
    public static void main(String[] args) {
        Exercise14 e = new Exercise14();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<List<String>> ladder = e.findLadders(beginWord, endWord, wordList);
        System.out.println(ladder);
    }

    List<List<String>> res;
    int min = -1;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        if (wordList != null) {
            words.addAll(wordList);
        }
        Set<String> visited = new HashSet<>();
        if (!words.contains(endWord)) return new ArrayList<>();

        res = new ArrayList<>();

        List<String> list = new ArrayList<>();

        list.add(beginWord);
        visited.add(beginWord);
        dfs(beginWord, endWord, words, visited, list);

        return res;
    }

    private void dfs(String beginWord, String endWord, Set<String> words, Set<String> visited, List<String> list) {

        if (beginWord.equals(endWord)) {
            if (min == -1 || list.size() == min) {
                res.add(new ArrayList<>(list));
                if (min == -1) {
                    min = list.size();
                }
            } else if (list.size() < min) {
                res = new ArrayList<>();
                res.add(new ArrayList<>(list));
                min = list.size();
            }
            return;
        }

        // 可选列表
        for (String word : words) {
            if (!visited.contains(word) && isValid(word, beginWord)) {
                visited.add(word);
                list.add(word);
                dfs(word, endWord, words, visited, list);
                list.remove(list.size() - 1);
                visited.remove(word);
            }
        }
    }

    private boolean isValid(String word, String cur) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != cur.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
