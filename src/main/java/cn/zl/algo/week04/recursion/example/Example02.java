package cn.zl.algo.week04.recursion.example;

/**
 * 例题2. 细胞分裂
 *
 * 1个细胞的生命周期是3小时，1小时分裂一次。求n小时后，容器内有多少细胞（分裂、死亡完之后）？
 * 细胞会在每个小时的开始分裂、死亡，并且先分裂后死亡。
 *
 * @author: longzhang
 * @date: 2021/12/20
 */
public class Example02 {

    // f(n) = 2f(n - 1) - g(n - 3) // g(n-3)表示n-3小时开始新增的细胞个数，f(n-4)的细胞到n-3小时都会分裂，所以新增了f(n-4)
    // f(n) = 2f(n - 1) - f(n - 4)
    // TODO 重点理解递推公式推导过程
    public int f(int n) {
        // 初始化0小时时开始只有1个细胞
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 4;
        if (n == 3) return 8;
        return 2 * f(n - 1) - f(n - 4);
    }
}
