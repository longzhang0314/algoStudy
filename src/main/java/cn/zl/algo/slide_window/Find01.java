package cn.zl.algo.slide_window;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @author: longzhang
 * @date: 2021/12/23
 */
public class Find01 {

    public static void main(String[] args) {
        Find01 f = new Find01();
        System.out.println(f.lengthOfLongestSubstring2("abcabcbb"));
    }

    // 滑动窗口：双端队列 + 哈希表存储元素个数
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        // 记录元素出现个数
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> deque = new ArrayDeque<>();
        deque.offerLast(s.charAt(0));
        map.put(s.charAt(0), 1);
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.getOrDefault(c, 0) == 1) {
                while (deque.peekFirst() != c) {
                    char pop = deque.pollFirst();
                    map.put(pop, 0);
                }
                deque.pollFirst();
            } else {
                map.put(c, 1);
            }
            deque.offerLast(c);
            max = Math.max(max, deque.size());
        }
        return max;
    }

    // 滑动窗口：数组遍历 + 哈希表存储索引
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 1;
        // 队列最左侧的索引
        int left = 0;
        // 记录元素在队列中的索引
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int prevIdx = map.get(c);
                // 该索引及之前的元素全部出队
                left = Math.max(left, prevIdx + 1);
            }
            max = Math.max(max, i - left + 1);
            map.put(c, i);
        }
        return max;
    }
}
