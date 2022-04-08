package cn.zl.algo.week11.dp.exercise.type01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139.单词拆分
 *
 * TODO do late 【重要】爬楼梯，可以trie树优化
 *
 * 后缀匹配，前面部分可达
 *
 * @author liusha
 * @date 2022/2/28
 */
public class Exercise06 {

    public static void main(String[] args) {
        Exercise06 e = new Exercise06();
        String s = "leetcode";
        System.out.println(s.startsWith("de", 6));
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(e.wordBreak(s, wordDict));
    }

    // 代码优化后版本
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        // 以i结尾时是否可以满足
        boolean[] dp = new boolean[n];
        if (set.contains(s.substring(0, 1))) {
            dp[0] = true;
        }

        for (int i = 1; i < n; i++) {
            // dp[j] && s[j+1,i] in set
            for (int j = -1; j < i; j++) {
                if (j != -1 && !dp[j]) continue;
                String sub = s.substring(j + 1, i + 1);
                if (set.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        int n = s.length();
        // dp[i]: 考察到第i个元素时是否可以组成；dp[i] = for (b[j+1,i] && dp[j])
        boolean[] dp = new boolean[n];
        String zero = s.substring(0, 1);
        for (String word : wordDict) {
            if (zero.equals(word)) {
                dp[0] = true;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                boolean pre = false;
                if (j <= 0 || dp[j - 1]) pre = true;
                if (!pre) continue;
                for (String word : wordDict) {
                    if (sub.equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
                if (dp[i]) break;
            }
        }

        return dp[n - 1];
    }


}
