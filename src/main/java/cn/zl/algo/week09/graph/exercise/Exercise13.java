package cn.zl.algo.week09.graph.exercise;

import java.util.*;

/**
 * 127. 单词接龙（困难）
 *
 *
 * @author liusha
 * @date 2022/2/21
 */
public class Exercise13 {

    public static void main(String[] args) {
        Exercise13 e = new Exercise13();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int i = e.ladderLength(beginWord, endWord, wordList);
        System.out.println(i);
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        if (wordList != null) {
            words.addAll(wordList);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        if (!words.contains(endWord)) return 0;

        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return step;
                }
                // 可选列表放入queue
                for (String word : words) {
                    if (!visited.contains(word) && isValid(word, cur)) {
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
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
