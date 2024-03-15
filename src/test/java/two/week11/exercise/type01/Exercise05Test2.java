package two.week11.exercise.type01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 流沙
 * @date 2024/3/14
 */
public class Exercise05Test2 {

    public static void main(String[] args) {
        Exercise05Test2 e = new Exercise05Test2();
        System.out.println(e.crackNumber(624));
    }

    // LCR 165. 解密数字
    //现有一串神秘的密文 ciphertext，经调查，密文的特点和规则如下：
    // 密文由非负整数组成
    // 数字 0-25 分别对应字母 a-z
    //
    // 请根据上述规则将密文 ciphertext 解密为字母，并返回共有多少种解密结果。
    //
    // 示例 1:
    //输入: ciphertext = 216612
    //输出: 6
    //解释: 216612 解密后有 6 种不同的形式，分别是 "cbggbc"，"vggbc"，"vggm"，"cbggm"，"cqggbc" 和
    //"cqggm"
    // 提示：
    // 0 <= ciphertext < 2³¹
    public int crackNumber(int ciphertext) {
        if (ciphertext == 0) return 1;
        // 每次取1位/2位 -> dp规则：由dp[i-2]/dp[i-1]而来
        List<Integer> list = new ArrayList<>();
        while (ciphertext > 0) {
            list.add(ciphertext % 10);
            ciphertext /= 10;
        }
        Collections.reverse(list);
        // 考察到第i个字母时，总的解密结果数
        int[] dp = new int[list.size()];
        dp[0] = 1;
        if (list.size() == 1) {
            return 1;
        }
        int zero = list.get(0);
        int one = list.get(0) * 10 + list.get(1);
        if (zero == 0) {
            dp[1] = 1;
        } else if (one > 25) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }
        for (int i = 2; i < list.size(); i++) {
            // i - 1是否为0，[i-1,i]是否大于25
            int pre = list.get(i - 1);
            int cur = list.get(i - 1) * 10 + list.get(i);
            if (pre == 0 || cur > 25) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[list.size() - 1];
    }
}
