package two.week12.pointer;

/**
 * @author 流沙
 * @date 2024/4/9
 */
public class Exercise09Test2 {

    // （1）每次定位w1和w2的索引位置，定位abs长度
    // （2）如何递进：下次遇到w1/w2时，是否一定能替换：没出来一个新值，一定是与其前面的值进行重新计算的，所以靠前的已经全部生成过结果了，新值替换即可
    public int findClosest(String[] words, String word1, String word2) {
        if (word1.equals(word2)) return 0;
        int n = words.length;
        int oneIdx = -1;
        int twoIdx = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) {
                oneIdx = i;
            } else if (words[i].equals(word2)) {
                twoIdx = i;
            }
            if (oneIdx != -1 && twoIdx != -1) {
                min = Math.min(min, Math.abs(twoIdx - oneIdx));
            }
        }
        return min;
    }


}
