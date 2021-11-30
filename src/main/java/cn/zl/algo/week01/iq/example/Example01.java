package cn.zl.algo.week01.iq.example;

/**
 * 现有x瓶啤酒，3个酒瓶换一瓶酒，7个瓶盖换一瓶酒，最后一共能喝多少瓶酒
 *
 * @author liusha
 * @date 2021/11/30
 */
public class Example01 {

    public int drink(int x) {
        if (x <= 0) return 0;
        int res = x;
        int bottle = x;
        int cover = x;
        while (bottle >= 3 || cover >= 7) {
            // 3个酒瓶换一瓶酒
            while (bottle >= 3) {
                int change = bottle / 3;
                res += change;
                bottle %= 3;
                bottle += change;
                cover += change;
            }
            // 7个瓶盖换一瓶酒
            while (cover >= 7) {
                int change = cover / 7;
                res += change;
                cover %= change;
                cover += change;
                bottle += change;
            }
        }
        return res;
    }


}
