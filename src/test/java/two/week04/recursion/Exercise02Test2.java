package two.week04.recursion;

/**
 * @author liusha
 * @date 2022/7/27
 */
public class Exercise02Test2 {

    // TODO 待测
    // 1次1 or 2,跳到n的方法，对1000000007取模
    public int numWays(int n) {
        if (n <= 1) return 1;
        int f1 = 1, f2 = 2;
        int f3 = 2;
        for (int i = 3; i <= n; i++) {
            f3 = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
