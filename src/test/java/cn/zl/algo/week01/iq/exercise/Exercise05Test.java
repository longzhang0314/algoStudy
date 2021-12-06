package cn.zl.algo.week01.iq.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liusha
 * @date 2021/12/6
 */
public class Exercise05Test {

    // 红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
    public int[] masterMind(String solution, String guess) {
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


    public int[] masterMind2(String solution, String guess) {
        int real = 0, total = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> gMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            char s = solution.charAt(i), g = guess.charAt(i);
            if (s == g) {
                real++;
            }
            sMap.put(s, sMap.getOrDefault(s, 0) + 1);
            gMap.put(g, gMap.getOrDefault(g, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (gMap.containsKey(key)) {
                total += Math.min(value, gMap.get(key));
            }
        }
        return new int[]{real, total - real};
    }
}
