package cn.zl.algo.week12.pointer.exercise;

/**
 * 面试题 17.11 单词距离
 *
 * //有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，
 * //你能对此优化吗?
 * //
 * // 示例：
 * //
 * // 输入：words = ["I","am","a","student","from","a","university","in","a","city"],
 * //word1 = "a", word2 = "student"
 * //输出：1
 * //
 * // 提示：
 * //
 * //
 * // words.length <= 100000
 *
 * @author liusha
 * @date 2022/3/24
 */
public class Exercise09 {


    public static void main(String[] args) {
        Exercise09 e = new Exercise09();
        String[] words = {"I","am","a","student","from","a","university","in","a","city"};
        String word1 = "a";
        String word2 = "student";
        System.out.println(e.findClosest(words, word1, word2));
    }


    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length;
        int oneIdx = -1;
        int twoIdx = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (word1.equals(words[i])) {
                oneIdx = i;
            } else if (word2.equals(words[i])) {
                twoIdx = i;
            } else {
                continue;
            }
            if (oneIdx != -1 && twoIdx != -1) {
                min = Math.min(min, Math.abs(oneIdx - twoIdx));
            }
        }
        return min;
    }
}
