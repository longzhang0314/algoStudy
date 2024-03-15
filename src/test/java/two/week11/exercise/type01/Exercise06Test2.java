package two.week11.exercise.type01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 流沙
 * @date 2024/3/15
 */
public class Exercise06Test2 {

    public static void main(String[] args) {
        Exercise06Test2 e = new Exercise06Test2();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(e.wordBreak(s, wordDict));
    }

    // 139.
    //给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
    // 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    //
    //输入: s = "leetcode", wordDict = ["leet", "code"]
    //输出: true
    //解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
    //
    //输入: s = "applepenapple", wordDict = ["apple", "pen"]
    //输出: true
    //解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
    //
    // 1 <= s.length <= 300
    // 1 <= wordDict.length <= 1000
    // 1 <= wordDict[i].length <= 20
    // s 和 wordDict[i] 仅由小写英文字母组成
    // wordDict 中的所有字符串 互不相同
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        if (set.contains(s.substring(0, 1))) {
            dp[0] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (set.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
