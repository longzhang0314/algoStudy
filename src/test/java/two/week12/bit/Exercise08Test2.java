package two.week12.bit;


/**
 * @author 流沙
 * @date 2024/7/4
 */
public class Exercise08Test2 {

    public static void main(String[] args) {
        Exercise08Test2 e = new Exercise08Test2();
        // 3: 0 0 1 1; 4: 0 1 0 0
        int[] nums = {3, 4, 3, 3};
        System.out.println(e.singleNumber(nums));
    }

    // 除一个出现1次，其余出现3次
    public int singleNumber(int[] nums) {
        // 统计二进制位出现1的个数，对3取余，剩余的二进制还原为十进制即为解
        // i=0表示低位0
        int[] cnt = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < 32; j++) {
                if ((num & (1 << j)) != 0) {
                    cnt[j]++;
                }
            }
        }
        // 对3取余
        for (int i = 0; i < 32; i++) {
            cnt[i] %= 3;
        }
        // cnt复原：二进制转十进制，只会有1和0
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (cnt[i] << i);
        }
        return res;
    }

}
