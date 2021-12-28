package cn.zl.algo.week05.hash.common;

/**
 * @author: longzhang
 * @date: 2021/12/28
 */
public class BitMapDemo {

    public static void main(String[] args) {
        MyBitMap myBitMap = new MyBitMap(64);
        myBitMap.set(2);
        System.out.println(myBitMap.get(2));
        System.out.println(myBitMap.get(1));
    }
}
