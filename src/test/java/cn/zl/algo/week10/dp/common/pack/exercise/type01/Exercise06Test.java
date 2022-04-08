package cn.zl.algo.week10.dp.common.pack.exercise.type01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liusha
 * @date 2022/4/7
 */
public class Exercise06Test {

    public static void main(String[] args) {
        Exercise06Test e = new Exercise06Test();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(e.wordBreak(s, wordDict));
    }


    public boolean wordBreak(String s, List<String> wordDict) {
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
}
