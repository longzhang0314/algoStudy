package two.week09.graph.exercise;

import java.util.*;

/**
 * @author 流沙
 * @date 2023/11/28
 */
public class Exercise10Test2 {

    // 测试用例:"hit"
    //			"cog"
    //			["hot","dot","dog","lot","log","cog"]
    //	测试结果:[]
    //	期望结果:["hit","hot","dot","lot","log","cog"]
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hit","hot","dot","lot","log","cog");
        Exercise10Test2 e = new Exercise10Test2();
        List<String> ladders = e.findLadders(begin, end, wordList);
        System.out.println(ladders);
    }


    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return null;
        List<String> list = new ArrayList<>(wordList.size());
        // begin: find list it is in wordList, not visited and diff=1, foreach and dfs
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        list.add(beginWord);
        dfs(beginWord, endWord, wordList, list, visited);
        return found ? list : new ArrayList<>();
    }

    boolean found = false;
    private void dfs(String beginWord, String endWord, List<String> wordList, List<String> list, Set<String> visited) {
        if (found) return;
        if (beginWord.equals(endWord)) {
            found = true;
            return;
        }
        // update begin if valid
        for (String word : wordList) {
            if (!visited.contains(word) && diffOne(beginWord, word)) {
                visited.add(word);
                list.add(word);
                dfs(word, endWord, wordList, list, visited);
                if (found) return;
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean diffOne(String a, String b) {
        if (a.equals(b) || a.length() != b.length()) return false;
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }

        return diff == 1;
    }


}
