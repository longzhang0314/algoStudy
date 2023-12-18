package two.week09.graph.exercise;

import java.util.*;

/**
 * @author 流沙
 * @date 2023/12/14
 */
public class Exercise13Test2 {

    public static void main(String[] args) {
        Exercise13Test2 e = new Exercise13Test2();
        String begin = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(e.ladderLength(begin, end, wordList));
    }

    // 全小写英文字母
    // 除begin外，都应该在wordlist中
    // 最短长度，包含begin和end
    // 无法到达，则返回0

    // 方案：
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



    // ==================== 方法1 ======================================================================

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0
                || beginWord.length() != endWord.length()) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (endWord.equals(cur)) {
                    return step;
                }
                for (String sub : wordList) {
                    if (visited.contains(sub)) continue;
                    if (!diffOne(cur, sub)) continue;
                    visited.add(sub);
                    queue.offer(sub);
                }
            }
        }
        return 0;
    }
}
