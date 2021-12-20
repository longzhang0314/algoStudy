package cn.zl.algo.week04.recursion.exercise;

/**
 * 面试题 08.05 递归乘法（中等）
 *
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * 输入：A = 1, B = 10
 *  输出：10
 *
 * @author liusha
 * @date 2021/12/20
 */
public class Exercise08 {

    public static void main(String[] args) {
        Exercise08 e = new Exercise08();
        System.out.println(e.multiply(10, 1));
        System.out.println(e.multiply(2, 5));
        System.out.println(e.multiply(5, 2));
    }

    public int multiply(int A, int B) {
        if (A < B) return multiply(B, A);
        if (B == 1) return A;
        return (B & 1) == 1 ? A + multiply(A + A, B >> 1) : multiply(A + A, B >> 1);
    }
}
