package two.week05.hash;


/**
 * @author liusha
 * @date 2023/4/11
 */
public class Exercise08Test2 {


    // 长度n，val都在[0,n-1]
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int[] cnt = new int[n];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > 1) {
                return num;
            }
        }
        return -1;
    }


    // bitmap n
    public int findRepeatNumber2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        BitMap bitMap = new BitMap(n);
        for (int num : nums) {
            if (bitMap.get(num)) return num;
            bitMap.put(num);
        }
        return -1;
    }

    private static class BitMap {
        private int n;
        // char两个字节，16位
        private char[] chs;

        public BitMap(int n) {
            this.n = (n - 1) / 16 + 1;
            this.chs = new char[this.n];
        }

        public void put(int num) {
            int idx = num / 16;
            int bitIdx = num % 16;
            chs[idx] |= (1 << bitIdx);
        }

        public boolean get(int num) {
            int idx = num / 16;
            int bitIdx = num % 16;
            return (chs[idx] & (1 << bitIdx)) != 0;
        }
    }

}
