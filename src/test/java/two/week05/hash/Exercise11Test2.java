package two.week05.hash;

/**
 * @author liusha
 * @date 2023/4/11
 */
public class Exercise11Test2 {

    public int singleNumber(int[] nums) {
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }
}
