package two.week12.bit;

/**
 * 461
 * @author 流沙
 * @date 2024/6/24
 */
public class Exercise02Test2 {

    public int hammingDistance(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            int a = x & (1 << i);
            int b = y & (1 << i);
            if (a != b) cnt++;
        }
        return cnt;
    }

}
