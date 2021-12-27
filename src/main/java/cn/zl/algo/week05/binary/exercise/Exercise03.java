package cn.zl.algo.week05.binary.exercise;

/**
 * 744. 寻找比目标字母大的最小字母（简单）
 *
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *
 *
 * @author liusha
 * @date 2021/12/27
 */
public class Exercise03 {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                if (mid == 0 || letters[mid - 1] <= target) return letters[mid];
                else right = mid - 1;
            } else if (letters[mid] <= target) {
                left = mid + 1;
            }
        }
        return letters[0];
    }

}
