package cn.zl.algo.week05.binary.exercise;

/**
 * 面试题 10.05 稀疏数组搜做（简单）
 *
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 *
 * 【注意】 可以优化
 * @author liusha
 * @date 2021/12/27
 */
public class Exercise06 {
    public int findString1(String[] words, String s) {
        if (words == null || words.length == 0) return -1;
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].equals("")) {
                if (words[left].equals(s)) return left;
                else left++;
            } else if (words[mid].compareTo(s) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int findString(String[] words, String s) {
        if (words == null || words.length == 0) return -1;
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (words[mid].equals(s)) {
                return mid;
            }
            if (!"".equals(words[mid])) {
                if (words[mid].compareTo(s) > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 找到左边第一个不为""的
                int i = mid;
                while (i >= left && "".equals(words[i])) {
                    i--;
                }
                if (i < left) {
                    left = mid + 1;
                } else if (words[i].equals(s)) {
                    return i;
                } else if (words[i].compareTo(s) > 0) {
                    right = i - 1;
                } else {
                    left = mid + 1;
                }

            }
        }
        return -1;
    }

}
