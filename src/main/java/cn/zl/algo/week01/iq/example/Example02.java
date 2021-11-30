package cn.zl.algo.week01.iq.example;


/**
 * 剑指offer61. 扑克牌中的顺子
 *
 * 随机取出5张牌，看是不是顺子；
 * A为1，J为11，Q为12，K为13，大小王为0可以代表任何数，A不能为14。
 *
 */
public class Example02 {

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) return false;
        // 先不考虑0，因为0可以顶替任何数；
        // 除0以外，5张牌里面只要不重复，并且最大的和最小的差值小于等于4，那么合法
        // 因为剩余的位置都可以用0补齐，但是如果差值大于5，那么有0也无济于事
        int min = 100, max = -1;
        boolean[] visited = new boolean[14];
        for (int num : nums) {
            if (visited[num]) return false;
            visited[num] = true;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min <= 4;
    }
}
