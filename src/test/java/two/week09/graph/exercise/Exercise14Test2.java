package two.week09.graph.exercise;

import java.util.*;

/**
 * @author 流沙
 * @date 2023/12/18
 */
public class Exercise14Test2 {

    public static void main(String[] args) {
        Exercise14Test2 e = new Exercise14Test2();
        String begin = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        List<List<String>> res = e.findLadders(begin, end, wordList);
        System.out.println(res);
    }

    // dfs: 超时
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0
                || beginWord.length() != endWord.length()) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        List<String> list = new ArrayList<>();
        visited.add(beginWord);
        list.add(beginWord);
        dfs(beginWord, endWord, wordList, res, list, 1, visited);
        return res;
    }

    int minStep = Integer.MAX_VALUE;
    private void dfs(String beginWord, String endWord, List<String> wordList, List<List<String>> res, List<String> list, int step, Set<String> visited) {
        if (step > minStep) return;
        if (beginWord.equals(endWord)) {
            while (res.size() > 0 && res.get(res.size() - 1).size() > list.size()) {
                res.remove(res.size() - 1);
            }
            res.add(new ArrayList<>(list));
            minStep = step;
            return;
        }
        for (String sub : wordList) {
            if (visited.contains(sub)) continue;
            if (!diffOne(sub, beginWord)) continue;
            visited.add(sub);
            list.add(sub);
            dfs(sub, endWord, wordList, res, list, step + 1, visited);
            list.remove(list.size() - 1);
            visited.remove(sub);
        }
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
