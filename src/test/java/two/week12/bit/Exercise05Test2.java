package two.week12.bit;

/**
 * @author 流沙
 * @date 2024/6/24
 */
public class Exercise05Test2 {

    public int insertBits(int N, int M, int i, int j) {
        if (j - i > 31) return N;
        // M放入N的第[i,j]位置，i：从最低位开始，从0开始计数
        for (int k = 0; k <= j - i; k++) {
            // M的当前位是1，则 | 到N里；M的当前位是0，则 & 到N里
            boolean mOne = (M & (1 << k)) != 0;
            int i1 = (1 << (k + i));
            if (mOne) {
                N |= i1;
            } else {
                N &= (~i1);
            }
        }
        return N;
    }
}
