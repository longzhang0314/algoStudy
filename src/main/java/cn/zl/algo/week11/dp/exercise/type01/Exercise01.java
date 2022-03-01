package cn.zl.algo.week11.dp.exercise.type01;

/**
 * 70.爬楼梯
 * @author liusha
 * @date 2022/2/28
 */
public class Exercise01 {

    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        int f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }

}
