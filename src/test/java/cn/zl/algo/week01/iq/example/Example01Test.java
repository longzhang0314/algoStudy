package cn.zl.algo.week01.iq.example;

/**
 * @author liusha
 * @date 2021/12/3
 */
public class Example01Test {


    public int drink(int x) {
        if (x <= 0) return 0;
        int res = x;
        int bottle = x;
        int cover = x;
        while (bottle >= 3 || cover >= 7) {
            while (bottle >= 3) {
                int change = bottle / 3;
                bottle %= 3;
                res += change;
                bottle += change;
                cover += change;
            }

            while (cover >= 7) {
                int change = cover / 7;
                cover %= 7;
                res += change;
                bottle += change;
                cover += change;
            }
        }
        return res;
    }
}
