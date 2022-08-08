package two.week04.recursion;

/**
 * @author liusha
 * @date 2022/7/27
 */
public class Exercise08Test02 {

    public int multiply(int A, int B) {
        if (B > A) return multiply(B, A);
        // A一定大于B
        if (B == 1) return A;
        return (B & 1) == 1 ? A + multiply(A + A, B >> 1) : multiply(A + A, B >> 1);
    }
}
