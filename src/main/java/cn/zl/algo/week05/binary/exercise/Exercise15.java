package cn.zl.algo.week05.binary.exercise;

/**
 * 875. 爱吃香蕉的珂珂（中等）
 *
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 *
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 *
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *
 * 提示：
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * @author liusha
 * @date 2021/12/28
 */
public class Exercise15 {

    // 找到max，一次吃max绝对可以吃完，因为piles.length <= H
    // 二分[1,max]，找到可以吃完的最小值
    // 可以吃完的标准：吃的天数<=H
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        // 这里可以O(N)，因为数据规模是10^4
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        int left = 1, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 以mid的速度吃，能吃多少小时
            int use = eat(piles, mid);
            if (use <= h) {
                if (mid == 1 || eat(piles, mid - 1) > h) return mid;
                else right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    private int eat(int[] piles, int speed) {
        int day = 0;
        for (int pile : piles) {
            day += (pile - 1) / speed + 1;
        }
        return day;
    }


}
