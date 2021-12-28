package cn.zl.algo.week05.hash.common;

/**
 * 位图：每个二进制位存储一个元素
 *
 * 示例：存储数字范围0-63的整数，需要64个二进制位。
 *
 * @author: longzhang
 * @date: 2021/12/28
 */
public class MyBitMap {

    private char[] a;
    private int nbits;

    public MyBitMap(int nbits) {
        this.nbits = nbits;
        this.a = new char[(nbits - 1) / 16 + 1];
    }

    public void set(int k) {
        if (k > nbits) return;
        int charIdx = k / 16;
        int bitIdx = k % 16;
        a[charIdx] |= (1 << bitIdx);
    }

    public boolean get(int k) {
        if (k > nbits) return false;
        int charIdx = k / 16;
        int bitIdx = k % 16;
        return (a[charIdx] & (1 << bitIdx)) != 0;
    }

}
