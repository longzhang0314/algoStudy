package two.week05.binary;

/**
 * @author liusha
 * @date 2022/9/1
 */
public class Exercise18Test2 {

    public static void main(String[] args) {
        Exercise18Test2 e = new Exercise18Test2();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(e.findMedianSortedArrays2(nums1, nums2));
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;
        // 确保nums1更短
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length, n = nums2.length;
        // 奇数左边多一个
        int leftTotal = (m + n + 1) / 2;
        // 对短的数组二分，推断长的数组位置
        // 二分：（1）实际上是分隔线的位置：分隔线可以取值[0,num.length]
        // （2）如果是奇数个，保证左侧多一个

        // 二分临时使用
        int n1Left = 0, n1Right = m;
        int n1Mid, n2Mid;
        int n1MidLeftVal = 0, n1MidRightVal = 0, n2MidLeftVal = 0, n2MidRightVal = 0;
        while (n1Left <= n1Right) {
            n1Mid = n1Left + (n1Right - n1Left) / 2;
            n2Mid = leftTotal - n1Mid;
            // 分隔线终止条件：n1的mid-1<=n2的mid+1，n1的mid+1>=n2的mid-1
            n1MidLeftVal = n1Mid == 0 ? Integer.MIN_VALUE : nums1[n1Mid - 1];
            n1MidRightVal = n1Mid == m ? Integer.MAX_VALUE : nums1[n1Mid];
            n2MidLeftVal = n2Mid == 0 ? Integer.MIN_VALUE : nums2[n2Mid - 1];
            n2MidRightVal = n2Mid == n ? Integer.MAX_VALUE : nums2[n2Mid];
            if (n1MidLeftVal <= n2MidRightVal && n1MidRightVal >= n2MidLeftVal) {
                break;
            } else if (n1MidLeftVal > n2MidRightVal) {
                n1Right = n1Mid - 1;
            } else {
                n1Left = n1Mid + 1;
            }
        }

        // 判断奇偶
        if ((m + n) % 2 != 0) {
            // 奇数左边多一个，找多的里面较大的那个
            return Math.max(n1MidLeftVal, n2MidLeftVal);
        } else {
            int leftMax = Math.max(n1MidLeftVal, n2MidLeftVal);
            int rightMin = Math.min(n1MidRightVal, n2MidRightVal);
            return ((double) leftMax + rightMin) / 2;
        }
    }
}
