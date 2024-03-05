package two.week11.exercise.type01;

/**
 * @author 流沙
 * @date 2024/3/5
 */
public class Exercise01Test2 {

    public int climbStairs(int n) {
        if (n < 3) return n;
        int f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
