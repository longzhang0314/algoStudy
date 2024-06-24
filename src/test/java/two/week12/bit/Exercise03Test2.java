package two.week12.bit;

/**
 * @author 流沙
 * @date 2024/6/24
 */
public class Exercise03Test2 {

    public int convertInteger(int A, int B) {
        // 异或，然后判断1的个数
        int res = 0;
        int x = A ^ B;
        for (int i = 0; i < 32; i++) {
            if ((x & (1 << i)) != 0) res++;
        }
        return res;
    }
}
