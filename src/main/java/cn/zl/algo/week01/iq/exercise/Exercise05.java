package cn.zl.algo.week01.iq.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.15. 珠玑妙算 （简单）
 *
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 *
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。
 *
 * 作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。
 * 要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 *
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 *
 * 【注意】其他方法，无需哈希
 */
public class Exercise05 {

    /**
     * 输入： solution="RGBY",guess="GGRR"
     * 输出： [1,1]
     * 解释： 猜中1次，伪猜中1次。
     *
     * len(solution) = len(guess) = 4
     * solution和guess仅包含"R","G","B","Y"这4种字符
     *
     * @param solution
     * @param guess
     * @return
     */
    // 哈希表 + 遍历
    public int[] masterMind(String solution, String guess) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapG = new HashMap<>();
        int realGuess = 0;
        for (int i = 0; i < 4; i++) {
            char a = solution.charAt(i);
            char b = guess.charAt(i);
            if (a == b) {
                realGuess++;
            }
            mapS.put(a, mapS.getOrDefault(a, 0) + 1);
            mapG.put(b, mapG.getOrDefault(b, 0) + 1);
        }
        int totalGuess = 0;
        for (Map.Entry<Character, Integer> entryS : mapS.entrySet()) {
            Character key = entryS.getKey();
            Integer valueS = entryS.getValue();
            Integer valueG = mapG.getOrDefault(key, 0);
            totalGuess += Math.min(valueS, valueG);
        }

        return new int[]{realGuess, totalGuess - realGuess};
    }

    // 特殊哈希数组
    public int[] masterMind2(String solution, String guess) {
        int n = solution.length();
        int real = 0, total = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('Y', 1);
        map.put('G', 2);
        map.put('B', 3);
        int[] sArr = new int[4];
        int[] gArr = new int[4];
        for (int i = 0; i < n; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                real++;
            }
            sArr[map.get(solution.charAt(i))]++;
            gArr[map.get(guess.charAt(i))]++;
        }
        for (int i = 0; i < 4; i++) {
            total += Math.min(sArr[i], gArr[i]);
        }
        return new int[]{real, total - real};
    }


    // 直观的猜测过程, 无需哈希
    public int[] masterMind3(String solution, String guess) {
        int n = solution.length();
        boolean[] used = new boolean[n];
        int real = 0;
        int fake = 0;
        // 找到真猜中
        for (int i = 0; i < n; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                real++;
                used[i] = true;
            }
        }
        // 伪猜中判断
        for (int i = 0; i < n; i++) {
            char g = guess.charAt(i);
            char s = solution.charAt(i);
            // 当前真实猜中，直接跳过
            if (s == g) continue;
            for (int j = 0; j < n; j++) {
                if (j != i && !used[j] && g == solution.charAt(j)) {
                    fake++;
                    used[j] = true;
                    break;
                }
            }
        }
        return new int[]{real, fake};
    }
}
