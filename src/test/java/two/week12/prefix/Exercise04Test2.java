package two.week12.prefix;

/**
 * 42
 * @author 流沙
 * @date 2024/4/9
 */
public class Exercise04Test2 {

    public static void main(String[] args) {
        // height = [0,1,0,2,1,0,1,3,2,1,2,1]
        //输出：6
        Exercise04Test2 e = new Exercise04Test2();
        int[] trap = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(e.trap(trap));
    }

    // 1.prefix;2.stack
    public int trap2(int[] height) {
        if (height == null || height.length < 3) return 0;
        int n = height.length;

    }


    // 1:left max and right max
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int n = height.length;
        // 包含当前节点的左侧左侧最大值
        int[] leftPrefix = new int[n];
        for (int i = 1; i < n; i++) {
            leftPrefix[i] = Math.max(leftPrefix[i - 1], height[i - 1]);
        }
        int[] rightPrefix = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightPrefix[i] = Math.max(rightPrefix[i + 1], height[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(leftPrefix[i], rightPrefix[i]);
            if (height[i] < min) {
                res += (min - height[i]);
            }
        }
        return res;
    }

}
