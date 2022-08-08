package two.week04.recursion;

/**
 * @author liusha
 * @date 2022/7/27
 */
public class Exercise03Test {

    // TODO 待测
    // 1、2、3，多少种，1000000007
    public int waysToStep(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int f1 = 1, f2 = 2, f3 = 4;
        int f4 = 3;
        for (int i = 4; i <= n; i++) {
            f4 = ((f1 + f2) % 1000000007 + f3) % 1000000007;
            f1 = f2;
            f2 = f3;
            f3 = f4;
        }
        return f4;
    }
}
