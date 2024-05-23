package two.week12.prefix;

/**
 * @author 流沙
 * @date 2024/4/9
 */
public class Exercise03Test2 {

    public static void main(String[] args) {
        Exercise03Test2 e = new Exercise03Test2();
        // 10101110011011011000110000
//        System.out.println(e.reverseBits1(45725232));// 5
//        System.out.println(e.reverseBits1(6));// 3
        // 11011101111
        System.out.println(e.reverseBits3(1775));// 8
    }

    // method3：dp
    // 以当前节点为结尾的最大值
    public int reverseBits3(int num) {
        // 二维：0:无转换的最大连续值；1:转换一次的最大值
        int[][] dp = new int[32][2];
        dp[0][0] = (num & 1) == 0 ? 0 : 1;
        dp[0][1] = dp[0][0] == 0 ? 1 : -1;
        for (int i = 1; i < 32; i++) {
            boolean isZero = (num & (1 << i)) == 0;
            dp[i][0] = isZero ? 0 : dp[i - 1][0] + 1;
            dp[i][1] = isZero ? dp[i - 1][0] + 1 : dp[i - 1][1] == -1 ? -1 : dp[i - 1][1] + 1;
        }
        int max = 0;
        for (int i = 0; i < 32; i++) {
            max = Math.max(max, dp[i][0]);
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }



    // method2：在method1基础上，提前统计好左右两侧的连续1的个数
    // 统计优化：左侧连续1，且包含当前位；右侧同理
    // 从第0位开始，即为数组最低位
    public int reverseBits2(int num) {
        int[] left = new int[32];
        left[31] = (num & (1 << 31)) == 0 ? 0 : 1;
        for (int i = 30; i >= 0; i--) {
            if ((num & (1 << i)) == 0) {
                continue;
            }
            left[i] = left[i + 1] + 1;
        }
        int[] right = new int[32];
        right[0] = (num & 1) == 0 ? 0 : 1;
        for (int i = 1; i < 32; i++) {
            if ((num & (1 << i)) == 0) {
                continue;
            }
            right[i] = right[i - 1] + 1;
        }

        int max = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                continue;
            }
            int cur = 1
                    + (i < 31 ? left[i + 1] : 0)
                    + (i > 0 ? right[i - 1] : 0);
            max = Math.max(max, cur);
        }
        return max == 0 ? 32 : max;
    }

    // method1：force method：32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
    public int reverseBits1(int num) {
        // method1: force：考察每1位时，延展左右两边的最大长度
        // 优化：当前位是0的，向左右延展即可，因为总会覆盖当前位是1的
        int max = 0;
        for (int i = 0; i < 32; i++) {
            boolean isZero = (num & (1 << i)) == 0;
            if (!isZero) continue;
            int curCnt = 1;
            // left 1 cnt
            for (int j = i - 1; j >= 0; j--) {
                if ((num & (1 << j)) != 0) {
                    curCnt++;
                } else {
                    break;
                }
            }
            // right 1 cnt
            for (int j = i + 1; j < 32; j++) {
                if ((num & (1 << j)) != 0) {
                    curCnt++;
                } else {
                    break;
                }
            }
            max = Math.max(max, curCnt);
        }
        return max == 0 ? 32 : max;
    }
}
