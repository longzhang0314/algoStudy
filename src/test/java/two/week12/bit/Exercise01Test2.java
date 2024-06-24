package two.week12.bit;

/**
 * @author 流沙
 * @date 2024/6/24
 */
public class Exercise01Test2 {

    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) cnt++;
        }
        return cnt;
    }
}
