package cn.zl.algo.week07.str.common;

/**
 * @author liusha
 * @date 2022/2/22
 */
public class RkMatch {

    public static void main(String[] args) {
        char[] a = {'a','b','c','d'};
        int n = a.length;
        char[] b = {'b', 'c', 'd'};
        int m = b.length;
        RkMatch r = new RkMatch();
        int rk = r.rk(a, n, b, m);
        System.out.println(rk);
    }

    /**
     * 找到主串中匹配模式串的第一个位置索引
     *
     * rk算法思路：主串长度n，模式串m，
     * 把主串划分为n-m+1个和模式串长度相等的子串，遍历主串过程中算出每个子串的hash值，和子串hash值比较。
     *
     * 假设只有小写字符
     * hash值计算：
     * 主串abcd
     * 子串1：abc: 0*26*26 + 1*26 + 2*1 = 28
     * 计算下一个子串的hash值时，用上一个子串的hash值使用错位相减，可以O(1)时间计算传下一个子串hash值
     * 子串2：
     * bcd(原始算法): 1*26*26 + 2*26 + 3*1 = 731
     * bcd(O(1)算法): (abc - a)*26 + d*1  ---->  (28 - 0*26*26)*26 + 3*1 = 731
     *
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     *
     *
     * 空间：O(1)
     * 时间：最好O(m), 最坏O(n+m)
     * @return
     */
    public int rk(char[] a, int n, char[] b, int m) {
        long modelHash = hash(b, 0, m);
        long subHash = hash(a, 0, m);
        if (modelHash == subHash) return 0;
        for (int i = m; i < n; i++) {
            subHash = (long) (subHash - (a[i - m] - 'a') * Math.pow(26, m - 1)) * 26 + (a[i] - 'a');
            if (subHash == modelHash) return i - m + 1;
        }
        return -1;
    }

    private long hash(char[] b, int start, int end) {
        int count = end - start;
        int pow = count - 1;
        long res = 0;
        while (start < end) {
            res += (b[start++] - 'a') * Math.pow(26, pow--);
        }
        return res;
    }
}
