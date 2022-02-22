package cn.zl.algo.week07.str.common;

/**
 * @author liusha
 * @date 2022/2/22
 */
public class BfMatch {

    public static void main(String[] args) {
        char[] a = {'a','b','c','d'};
        int n = a.length;
        char[] b = {'b', 'c', 'd'};
        int m = b.length;
        BfMatch r = new BfMatch();
        int rk = r.bf(a, n, b, m);
        System.out.println(rk);
    }


    /**
     * 找到主串中匹配模式串的第一个位置索引
     *
     * bf算法思路：主串长度n，模式串m
     * 把主串划分为n-m+1个和模式串长度相等的子串，逐个按每一位字符比较子串和模式串是否相等。
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     *
     *
     * 空间：O(1)
     * 时间：最好O(min(m, n)), 最坏O(n*m)
     * @return
     */
    public int bf(char[] a, int n, char[] b, int m) {
        // 主串划分为n-m+1个和模式串长度相等的子串
        for (int i = 0; i <= n - m; i++) {
            // 比较从i开始的子串和模式串是否匹配
            int j = 0;
            while (j < m) {
                if (a[i + j] != b[j]) {
                    break;
                }
                j++;
            }
            if (j == m) {
                // 找到了
                return i;
            }
        }
        return -1;
    }
}
