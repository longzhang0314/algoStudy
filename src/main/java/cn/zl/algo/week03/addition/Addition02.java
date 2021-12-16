package cn.zl.algo.week03.addition;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用 add first 或 add last 这套新的 API 改写 Deque 的代码
 * TODO 待做
 * @author: longzhang
 * @date: 2021/12/16
 */
public class Addition02 {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        // addFirst
        deque.push("a");
        deque.push("b");
        deque.push("c");
        // peekFirst
        String str = deque.peek();
        System.out.println(str); // c
        System.out.println(deque); // c b a
        while (!deque.isEmpty()) {
            System.out.println(deque.pop()); // c b a
        }
        System.out.println(deque); // 空

        System.out.println("====================================");

        //  add first 或 add last改写
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        String str1 = deque.getFirst();
        System.out.println(str1);
        System.out.println(deque);
        while (!deque.isEmpty()) {
            System.out.println(deque.removeFirst());
        }
        System.out.println();
    }
}
