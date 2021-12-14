package cn.zl.algo.week03.exercise;

import java.util.LinkedList;

/**
 * 面试题 03.06. 动物收容所（简单）
 *
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。
 * 在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。
 * 换言之，收养人不能自由挑选想收养的对象。
 *
 * 请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 *
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 *
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 *  输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 *
 * @author: longzhang
 * @date: 2021/12/14
 */
public class Exercise14 {
}

// 使用两个链表实现，本题主要是翻译题意
class AnimalShelf {

    private LinkedList<Integer> catQueue;
    private LinkedList<Integer> dogQueue;

    public AnimalShelf() {
        this.catQueue = new LinkedList<>();
        this.dogQueue = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal == null || animal.length == 0) return;
        if (animal[1] == 0) {
            catQueue.add(animal[0]);
        } else {
            dogQueue.add(animal[0]);
        }
    }

    public int[] dequeueAny() {
        if (catQueue.isEmpty() && dogQueue.isEmpty()) return new int[]{-1, -1};
        if (catQueue.isEmpty()) return new int[]{dogQueue.removeFirst(), 1};
        if (dogQueue.isEmpty()) return new int[]{catQueue.removeFirst(), 0};
        if (catQueue.getFirst() <= dogQueue.getFirst()) {
            return new int[]{catQueue.removeFirst(), 0};
        } else {
            return new int[]{dogQueue.removeFirst(), 1};
        }
    }

    public int[] dequeueDog() {
        if (dogQueue.isEmpty()) return new int[]{-1, -1};
        return new int[]{dogQueue.removeFirst(), 1};
    }

    public int[] dequeueCat() {
        if (catQueue.isEmpty()) return new int[]{-1, -1};
        return new int[]{catQueue.removeFirst(), 0};
    }
}
