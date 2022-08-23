package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/22
 */
public class Exercise15Test2 {

    // piles.length <= h：以piles中最大的速度吃，一定能吃完
    public int minEatingSpeed(int[] piles, int h) {
        // 最快速度
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        int left = 1, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 以mid速度吃需要多少天吃完
            int useDay = eat(piles, mid);
            if (useDay <= h) {
                // 是否是能吃完的最小速度
                if (mid == 1 || eat(piles, mid - 1) > h) return mid;
                else right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int eat(int[] piles, int speed) {
        int total = 0;
        for (int pile : piles) {
            total += (pile - 1) / speed + 1;
        }
        return total;
    }
}
