package cn.zl.algo.week12.pointer.exercise;

/**
 * 344.反转字符串
 *
 * @author liusha
 * @date 2022/3/21
 */
public class Exercise01 {

    public static void main(String[] args) {
        char[] chs = {'h', 'e', 'l', 'l', 'o'};
        Exercise01 e = new Exercise01();
        e.reverseString(chs);
        System.out.println("end");
    }

    public void reverseString(char[] s) {
        int len = s.length;
        int i = 0;
        while (i < len / 2) {
            char tmp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = tmp;
            i++;
        }
    }
}
