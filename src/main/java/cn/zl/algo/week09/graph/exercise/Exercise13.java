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


    // ================================================= 方法2 ===================================================


    // 每次从wordlist中取出一个与begin差异=1的值，继续到下一层
    // 需要visited防止重复选择
    // 同一层多次选择中取最短的
    // 方法2：dfs：但会考虑所有的情况，超时
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0
                || beginWord.length() != endWord.length()) return 0;
        Set<String> visited = new HashSet<>();
        int count = dfs(beginWord, endWord, wordList, visited);
        return count == -1 ? 0 : count;
    }

    private int dfs(String beginWord, String endWord, List<String> wordList, Set<String> visited) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        visited.add(beginWord);
        int min = Integer.MAX_VALUE;
        for (String word : wordList) {
            if (visited.contains(word)) continue;
            if (!diffOne(beginWord, word)) continue;
            int subCount = dfs(word, endWord, wordList, visited);
            if (subCount == -1) continue;
            min = Math.min(subCount, min);
        }
        visited.remove(beginWord);
        return min == Integer.MAX_VALUE ? -1 : min + 1;
    }

    private boolean diffOne(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0
                || a.length() != b.length()) return false;
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }

}
